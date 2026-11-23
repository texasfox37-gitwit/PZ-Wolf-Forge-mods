# TDDUP HF84 standalone bridge — Build 42.22.2 candidate

**Development source only. Not a stable release, and not yet live-tested in PZ 42.22.2.**

This directory contains a standalone Java `-javaagent` host for *Till Death Do Us Part* (TDDUP). The host is **not ZombieBuddy**. It reuses TDDUP's existing HF83 compiled bridge and substitutes native ASM collision hooks for two ZombieBuddy-hosted advices. Gameplay code remains in the TDDUP Workshop mod.

## What this branch does not change

The existing public v3.6.3 release and its direct launcher are untouched. **Do not edit `ProjectZomboid64.json` merely to test this source.** Earlier releases encountered launch failures after modifying that file. This branch intentionally ships no automatic JSON installer or end-user release ZIP.

## Building locally

1. Install JDK 21 or newer.
2. Supply the TDDUP-owned compiled `TDDUPZBFullBridge-HF83.jar` from your HF83 build at `vendor/TDDUPZBFullBridge-HF83.jar`. **Do not commit the vendor JAR** until its redistribution rights have been checked.
3. Run `./scripts/build.sh` (Git Bash/Linux). The result is `build/dist/TDDUPBridgeStandalone.jar`.
4. To run a *non-game* startup check: `javac --release 21 -d build/classes tests/Smoke.java && java -javaagent:build/dist/TDDUPBridgeStandalone.jar -cp build/classes Smoke`.

The build combines the existing **TDDUP** bridge classes and ASM with new standalone host code. The old compiled classes still target 42.20/42.21 and may require patching for 42.22.2.

## How it works

- `StandaloneAgent.premain()` obtains Java instrumentation at JVM startup without ZombieBuddy.
- It installs native collision advice for `IsoPlayer.isPushedByForSeparate` and `IsoGameCharacter.setBumpedChr`, subject to matching exact target descriptors.
- It filters two obsolete P2/P4 household transformers and calls the existing `tddup.hf67b.bridge.TDDUPBridgeAgent.agentmain` with the filtered instrumentation.
- The existing TDDUP bridge registers its Lua functions. A startup message is **not** proof that these Lua functions are usable.

**Never load the ZombieBuddy and standalone Java agents simultaneously.** This branch uses a separate standalone mod dependency. Follow a safe, validated direct-launch integration plan before putting it in front of players.

## Remaining release blockers

- Compare Java bytecode method signatures and ASM injection points with the exact PZ 42.22.2 engine.
- Verify companion model rendering, movement, collision, combat, Follow/Stay, child handling and Lua registration in a backed-up test save.
- Test farm, ranching, dialogue and optional animation/content modules.
- Confirm source/binary redistribution rights, provide a reproducible tested build and a no-JSON-edit launcher.
- Only then publish an end-user GitHub Release.

See `PORTING_NOTES.md` for the compatibility checklist.

**No telemetry, credentials, network calls, background service, game-file patching or save-file edits are included in this agent.**
