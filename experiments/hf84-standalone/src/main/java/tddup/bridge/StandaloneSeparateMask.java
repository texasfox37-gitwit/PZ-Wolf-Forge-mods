package tddup.bridge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import tddup.hf67p2.collision.HouseholdPairCollisionHooks;

/** HF84.1: temporary peer solidity mask during IsoMovingObject.separate(). */
public final class StandaloneSeparateMask {
    private static final AtomicBoolean ACTIVE_LOGGED = new AtomicBoolean();
    private static final AtomicBoolean ERROR_LOGGED = new AtomicBoolean();
    private static final AtomicLong MASKED_CALLS = new AtomicLong();
    private static final AtomicLong RESTORED_CALLS = new AtomicLong();
    private static final ThreadLocal<Deque<Frame>> TOKENS = ThreadLocal.withInitial(ArrayDeque::new);
    private record Frame(Object actor, Object token) {}
    private StandaloneSeparateMask() {}

    public static void enter(Object actor) {
        if (actor == null || !actor.getClass().getName().equals("zombie.characters.IsoPlayer")) return;
        try {
            Object token = HouseholdPairCollisionHooks.beginHouseholdSeparate(actor);
            if (token != null) {
                TOKENS.get().push(new Frame(actor, token));
                long count = MASKED_CALLS.incrementAndGet();
                if (ACTIVE_LOGGED.compareAndSet(false, true))
                    System.out.println("[TDDUP HouseholdCollision P4 Standalone] mask ACTIVE first-call=" + count +
                        " scope=household-peers-only worldCollision=unchanged");
            }
        } catch (Throwable ex) {
            if (ERROR_LOGGED.compareAndSet(false, true))
                System.err.println("[TDDUP HouseholdCollision P4 Standalone] begin FAILED: " + ex);
        }
    }

    public static void leave(Object actor) {
        if (actor == null || !actor.getClass().getName().equals("zombie.characters.IsoPlayer")) return;
        Deque<Frame> stack = TOKENS.get();
        if (stack.isEmpty()) return;
        try {
            while (!stack.isEmpty()) {
                Frame frame = stack.pop();
                HouseholdPairCollisionHooks.endHouseholdSeparate(frame.token());
                RESTORED_CALLS.incrementAndGet();
                if (frame.actor() == actor) break;
            }
        } catch (Throwable ex) {
            if (ERROR_LOGGED.compareAndSet(false, true))
                System.err.println("[TDDUP HouseholdCollision P4 Standalone] end FAILED: " + ex);
        } finally {
            if (stack.isEmpty()) TOKENS.remove();
        }
    }
    public static long masks() { return MASKED_CALLS.get(); }
    public static long restores() { return RESTORED_CALLS.get(); }
}
