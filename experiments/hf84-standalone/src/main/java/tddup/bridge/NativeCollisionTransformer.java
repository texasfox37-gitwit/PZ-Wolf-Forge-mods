package tddup.bridge;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.Opcodes;

/** TDDUP native replacements for two previous ZombieBuddy collision advices. */
public final class NativeCollisionTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> redefined,
                            ProtectionDomain domain, byte[] bytes) {
        if (!"zombie/characters/IsoPlayer".equals(className) &&
            !"zombie/characters/IsoGameCharacter".equals(className)) return null;
        try {
            ClassReader input = new ClassReader(bytes);
            ClassWriter output = new ClassWriter(input, ClassWriter.COMPUTE_MAXS);
            final int[] patches = { 0 };
            final boolean player = "zombie/characters/IsoPlayer".equals(className);
            ClassVisitor visitor = new ClassVisitor(Opcodes.ASM9, output) {
                @Override
                public MethodVisitor visitMethod(int flags, String name, String desc,
                                                 String signature, String[] exceptions) {
                    MethodVisitor original = super.visitMethod(flags, name, desc, signature, exceptions);
                    if (original == null || (flags & Opcodes.ACC_STATIC) != 0) return original;
                    Type[] args = Type.getArgumentTypes(desc);
                    boolean oneObjectArg = args.length == 1 &&
                        (args[0].getSort() == Type.OBJECT || args[0].getSort() == Type.ARRAY);
                    boolean playerSeparate = player && name.equals("isPushedByForSeparate")
                        && oneObjectArg && Type.getReturnType(desc).getSort() == Type.BOOLEAN;
                    boolean charBump = !player && name.equals("setBumpedChr")
                        && oneObjectArg && Type.getReturnType(desc).getSort() == Type.VOID;
                    if (!playerSeparate && !charBump) return original;
                    patches[0]++;
                    return new MethodVisitor(Opcodes.ASM9, original) {
                        @Override
                        public void visitCode() {
                            super.visitCode();
                            Label proceed = new Label();
                            mv.visitVarInsn(Opcodes.ALOAD, 0);
                            mv.visitVarInsn(Opcodes.ALOAD, 1);
                            mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                playerSeparate
                                    ? "tddup/zbfull/Patch_IsoPlayerHouseholdSeparate"
                                    : "tddup/zbfull/Patch_IsoGameCharacterBump",
                                "skip", "(Ljava/lang/Object;Ljava/lang/Object;)Z", false);
                            mv.visitJumpInsn(Opcodes.IFEQ, proceed);
                            if (playerSeparate) {
                                mv.visitInsn(Opcodes.ICONST_0);
                                mv.visitInsn(Opcodes.IRETURN);
                            } else {
                                mv.visitInsn(Opcodes.RETURN);
                            }
                            mv.visitLabel(proceed);
                            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                        }
                    };
                }
            };
            input.accept(visitor, 0);
            if (patches[0] == 0) {
                System.err.println("[TDDUP Standalone Bridge] native hook not found class=" + className);
                return null;
            }
            System.out.println("[TDDUP Standalone Bridge] native hook installed class="
                + className + " methods=" + patches[0]);
            return output.toByteArray();
        } catch (Throwable ex) {
            System.err.println("[TDDUP Standalone Bridge] native hook failed class="
                + className + " reason=" + ex);
            return null;
        }
    }
}
