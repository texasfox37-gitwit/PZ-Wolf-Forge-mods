package tddup.bridge;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;

/**
 * HF84.1 P4 restoration. All hooks are in-place; no class members are added
 * or renamed, so no schema-changing retransformation is needed.
 */
public final class NativeCollisionTransformer implements ClassFileTransformer {
    private static final String PLAYER = "zombie/characters/IsoPlayer";
    private static final String CHARACTER = "zombie/characters/IsoGameCharacter";
    private static final String MOVING = "zombie/iso/IsoMovingObject";

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> redefined,
                            ProtectionDomain domain, byte[] bytes) {
        final boolean player = PLAYER.equals(className);
        final boolean character = CHARACTER.equals(className);
        final boolean moving = MOVING.equals(className);
        if (!player && !character && !moving) return null;
        try {
            ClassReader input = new ClassReader(bytes);
            // May be retransformed: avoid double-decorating already-patched input.
            final boolean[] already = {false};
            input.accept(new ClassVisitor(Opcodes.ASM9) {
                @Override public MethodVisitor visitMethod(int flags, String name, String desc,
                                                              String signature, String[] exceptions) {
                    return new MethodVisitor(Opcodes.ASM9) {
                        @Override public void visitMethodInsn(int op, String owner, String method,
                                                               String desc, boolean itf) {
                            if ((moving && owner.equals("tddup/bridge/StandaloneSeparateMask") &&
                                    method.equals("enter"))
                                || (player && owner.equals("tddup/zbfull/Patch_IsoPlayerHouseholdSeparate") &&
                                    method.equals("skip"))
                                || (character && owner.equals("tddup/zbfull/Patch_IsoGameCharacterBump") &&
                                    method.equals("skip"))) already[0] = true;
                        }
                    };
                }
            }, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
            if (already[0]) return null;

            ClassWriter output = new ClassWriter(input, ClassWriter.COMPUTE_MAXS);
            final int[] patches = {0};
            ClassVisitor visitor = new ClassVisitor(Opcodes.ASM9, output) {
                @Override public MethodVisitor visitMethod(int flags, String name, String desc,
                                                              String signature, String[] exceptions) {
                    MethodVisitor original = super.visitMethod(flags, name, desc, signature, exceptions);
                    if (original == null ||
                        (flags & (Opcodes.ACC_STATIC | Opcodes.ACC_ABSTRACT | Opcodes.ACC_NATIVE)) != 0)
                        return original;
                    if (moving && name.equals("separate") && desc.equals("()V")) {
                        patches[0]++;
                        return new MethodVisitor(Opcodes.ASM9, original) {
                            private final Label tryStart = new Label();
                            private final Label tryEnd = new Label();
                            private final Label catchAll = new Label();

                            @Override public void visitCode() {
                                super.visitCode();
                                mv.visitTryCatchBlock(tryStart, tryEnd, catchAll, null);
                                mv.visitVarInsn(Opcodes.ALOAD, 0);
                                mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                    "tddup/bridge/StandaloneSeparateMask", "enter",
                                    "(Ljava/lang/Object;)V", false);
                                mv.visitLabel(tryStart);
                            }
                            @Override public void visitInsn(int op) {
                                if (op == Opcodes.RETURN) {
                                    mv.visitVarInsn(Opcodes.ALOAD, 0);
                                    mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                        "tddup/bridge/StandaloneSeparateMask", "leave",
                                        "(Ljava/lang/Object;)V", false);
                                }
                                super.visitInsn(op);
                            }
                            @Override public void visitMaxs(int maxStack, int maxLocals) {
                                mv.visitLabel(tryEnd);
                                mv.visitLabel(catchAll);
                                mv.visitFrame(Opcodes.F_FULL, 1, new Object[]{MOVING},
                                    1, new Object[]{"java/lang/Throwable"});
                                mv.visitVarInsn(Opcodes.ALOAD, 0);
                                mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                    "tddup/bridge/StandaloneSeparateMask", "leave",
                                    "(Ljava/lang/Object;)V", false);
                                mv.visitInsn(Opcodes.ATHROW);
                                super.visitMaxs(maxStack, maxLocals);
                            }
                        };
                    }

                    Type[] args = Type.getArgumentTypes(desc);
                    boolean oneObjectArg = args.length == 1 &&
                        (args[0].getSort() == Type.OBJECT || args[0].getSort() == Type.ARRAY);
                    boolean separate = player && name.equals("isPushedByForSeparate") && oneObjectArg &&
                        Type.getReturnType(desc).getSort() == Type.BOOLEAN;
                    boolean bump = character && name.equals("setBumpedChr") && oneObjectArg &&
                        Type.getReturnType(desc).getSort() == Type.VOID;
                    if (!separate && !bump) return original;
                    patches[0]++;
                    return new MethodVisitor(Opcodes.ASM9, original) {
                        @Override public void visitCode() {
                            super.visitCode();
                            Label proceed = new Label();
                            mv.visitVarInsn(Opcodes.ALOAD, 0);
                            mv.visitVarInsn(Opcodes.ALOAD, 1);
                            mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                separate ? "tddup/zbfull/Patch_IsoPlayerHouseholdSeparate" :
                                           "tddup/zbfull/Patch_IsoGameCharacterBump",
                                "skip", "(Ljava/lang/Object;Ljava/lang/Object;)Z", false);
                            mv.visitJumpInsn(Opcodes.IFEQ, proceed);
                            if (separate) {
                                mv.visitInsn(Opcodes.ICONST_0);
                                mv.visitInsn(Opcodes.IRETURN);
                            } else mv.visitInsn(Opcodes.RETURN);
                            mv.visitLabel(proceed);
                            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                        }
                    };
                }
            };
            input.accept(visitor, 0);
            if (patches[0] == 0) {
                System.err.println("[TDDUP Standalone Bridge] native hook NOT_FOUND class=" + className);
                return null;
            }
            System.out.println("[TDDUP Standalone Bridge] native hook installed class=" +
                className + " methods=" + patches[0]);
            return output.toByteArray();
        } catch (Throwable ex) {
            System.err.println("[TDDUP Standalone Bridge] native hook FAILED class=" +
                className + " reason=" + ex);
            return null;
        }
    }
}
