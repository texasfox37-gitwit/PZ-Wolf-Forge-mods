# HF84.1 standalone P4 regression test

Target: **PZ Build 42.22.2**, draft candidate, not live-verified.

The console `console(20261123-014506).txt` shows working P2 player/spouse veto and a patched P3 CollisionManager.AddContact; P4 was suppressed in standalone and had no equivalent `IsoMovingObject.separate()` hook.

The HF84.1 source now provides an **in-place** P4 method advice (no added or renamed class members), temporarily masking household peer solidity and restoring it on both ordinary return and exceptional exit. This complements, rather than replaces, P2 and P3.

## Local mock validation
- Java 21 compiler succeeds.
- JVM `-Xverify:all` succeeds with mock `IsoPlayer` and `IsoMovingObject` classes.
- A household spouse pair is recognized by the existing TDDUP hooks.
- During `separate()`, a household peer is temporarily not solid.
- After `separate()`, the peer is solid.
- The peer returns solid even if a callee throws.
- A subsequent `separate()` also restores solidity.

## Live verification required
1. Back up the existing standalone bridge JAR, then replace it with the HF84.1 bridge-only candidate.
2. Use a known-good direct launcher with **only one Java agent**. User logs still showed ZombieBuddy 2.3.4 active in addition to the standalone bridge (agents=2). Do not blindly edit `ProjectZomboid64.json`.
3. Confirm the standalone native hook reports installation for `zombie/iso/IsoMovingObject` (it may print before the file logger begins).
4. Check for P4 mask activation during normal movement, then check no spouse↔player pushes/blocking and ordinary zombie/world collisions.
5. Keep the pull request draft until validated on the real game.

An unrelated `IsoDoor.ToggleDoorActual` null-player exception also appeared in the user log; it is not proven related to household collisions.
