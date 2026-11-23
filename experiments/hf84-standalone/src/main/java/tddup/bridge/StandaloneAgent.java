package tddup.bridge;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Alternative startup host for the TDDUP-owned HF83 patch chain.
 * B42.22.2 game compatibility is not yet verified.
 */
public final class StandaloneAgent {
    private static final AtomicBoolean STARTED = new AtomicBoolean();
    private static volatile String state = "NOT_STARTED";
    private static volatile String error = "";

    private StandaloneAgent() {}

    public static void premain(String args, Instrumentation inst) { start(inst); }
    public static void agentmain(String args, Instrumentation inst) { start(inst); }

    private static void start(Instrumentation inst) {
        if (!STARTED.compareAndSet(false, true)) return;
        System.setProperty("tddup.bridge.host", "standalone");
        state = "STARTING";
        try {
            if (inst == null || !inst.isRetransformClassesSupported()) {
                throw new IllegalStateException("Retransformation is unavailable");
            }
            System.out.println("[TDDUP Standalone Bridge] start host=standalone target=42.22.2 port=candidate");
            ClassFileTransformer collision = new NativeCollisionTransformer();
            inst.addTransformer(collision, true);
            for (Class<?> loaded : inst.getAllLoadedClasses()) {
                String name = loaded.getName();
                if ((name.equals("zombie.characters.IsoPlayer") ||
                     name.equals("zombie.characters.IsoGameCharacter"))
                        && inst.isModifiableClass(loaded)) {
                    inst.retransformClasses(loaded);
                }
            }
            Instrumentation filtered = (Instrumentation) Proxy.newProxyInstance(
                StandaloneAgent.class.getClassLoader(),
                new Class<?>[] { Instrumentation.class },
                (proxy, method, args) -> {
                    if (method.getName().equals("addTransformer") &&
                        args != null && args.length > 0 && args[0] != null) {
                        String type = args[0].getClass().getName();
                        if (type.startsWith("tddup.hf67p2.collision.HouseholdPairCollisionAgent$") ||
                            type.startsWith("tddup.hf67p4.collision.HouseholdSeparationMaskAgent$")) {
                            System.out.println("[TDDUP Standalone Bridge] suppressed legacy transformer=" + type);
                            return null;
                        }
                    }
                    try {
                        return method.invoke(inst, args);
                    } catch (InvocationTargetException ex) {
                        throw ex.getCause();
                    }
                }
            );
            tddup.hf67b.bridge.TDDUPBridgeAgent.agentmain("host=standalone;collision=native", filtered);
            state = "DISPATCHED";
            System.out.println("[TDDUP Standalone Bridge] startup=DISPATCHED; verify Lua functions in game");
        } catch (Throwable ex) {
            state = "FAILED";
            error = ex.toString();
            System.err.println("[TDDUP Standalone Bridge] startup=FAILED reason=" + error);
            ex.printStackTrace(System.err);
        }
    }
    public static String status() { return state; }
    public static String failure() { return error; }
}
