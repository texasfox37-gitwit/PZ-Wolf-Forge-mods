# HF84 standalone bridge: status and validation

**Target:** Project Zomboid 42.22.2. **Status:** Java startup prototype; full runtime port unverified.

### Verified in isolated tests
- Java 21 compiler accepts both new host classes against the TDDUP HF83 JAR.
- Java premain starts without ZombieBuddy.
- TDDUP's legacy patch chain is dispatched through Instrumentation.
- Mock classes matching two old collision signatures receive native advice.
- Lua syntax checks on the HF84 test package passed: 244 scripts.
- Archive CRC and host-dependency separation checks passed.

### Important limitations
- HF83 Java patch stack still contains 42.20/42.21 instrumentation targets. Its ability to transform the shipped 42.22.2 classes is not yet proven.
- Older ZombieBuddy code discovery remains outside our control. The standalone agent avoids invoking it, but using both hosts is unsupported.
- Four HF84 game-mode-save-path scripts were made tolerant of string conversion; this is not a complete Lua API audit.
- The user's WolfForge knowledge bundle lists 42.22 engine/Lua ZIP archives, but they could not be directly extracted by the available reader. Do not claim source verification against them.
- This development branch intentionally does **not** modify the existing v3.6.3 public launcher or files.
- The pre-HF84 compiled bridge is TDDUP-specific legacy code; not all its source is present in this branch.

### Required test sequence
1. Verify exact `42.22.2` game build and Java runtime.
2. Confirm `[TDDUP Standalone Bridge] start host=standalone`.
3. Confirm `startup=DISPATCHED` and no transformer exceptions, VerifyError, or schema problems.
4. Confirm Lua bridge availability, not merely script file loading.
5. Test collision, rendering, movement, combat, spouse scene lifecycle, household task handoff, farming/ranching, and rollback with a backed-up save.
6. Obtain game console logs and update bytecode hooks before declaring stable.
