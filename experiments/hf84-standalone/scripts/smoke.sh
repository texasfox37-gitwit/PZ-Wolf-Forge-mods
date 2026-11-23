#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
test -f build/dist/TDDUPBridgeStandalone.jar || ./scripts/build.sh
javac --release 21 -d build/classes tests/Smoke.java tests/NativeHooksSmoke.java tests/mock/zombie/characters/*.java
java -javaagent:build/dist/TDDUPBridgeStandalone.jar -cp build/classes Smoke | tee build/smoke.log
grep -q TDDUP_SMOKE_MAIN_OK build/smoke.log
java -javaagent:build/dist/TDDUPBridgeStandalone.jar -cp build/classes NativeHooksSmoke | tee build/native.log
grep -q TDDUP_NATIVE_HOOKS_SMOKE_OK build/native.log
grep -q 'native hook installed class=zombie/characters/IsoPlayer' build/native.log
grep -q 'native hook installed class=zombie/characters/IsoGameCharacter' build/native.log
echo "JVM smoke tests passed; Project Zomboid B42.22.2 in-game compatibility NOT yet verified."
