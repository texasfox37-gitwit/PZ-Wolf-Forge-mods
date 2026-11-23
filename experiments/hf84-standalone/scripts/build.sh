#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
jar_path=vendor/TDDUPZBFullBridge-HF83.jar
if [[ ! -f "$jar_path" ]]; then
  echo "Missing $jar_path. Supply your own TDDUP HF83 bridge JAR; no public binary is bundled." >&2
  exit 2
fi
mkdir -p build/classes build/staging build/dist
javac --release 21 -cp "$jar_path" -d build/classes $(find src/main/java -name '*.java' | sort)
cat > build/manifest.mf <<'EOF'
Manifest-Version: 1.0
Premain-Class: tddup.bridge.StandaloneAgent
Agent-Class: tddup.bridge.StandaloneAgent
Can-Redefine-Classes: true
Can-Retransform-Classes: true
Implementation-Title: TDDUP Standalone Java Bridge
Implementation-Version: 0.1.0-42.22.2-test

EOF
rm -rf build/staging
mkdir build/staging
(cd build/staging && jar xf ../../"$jar_path")
rm -rf build/staging/META-INF
cp -a build/classes/. build/staging/
(cd build/staging && jar cfm ../dist/TDDUPBridgeStandalone.jar ../manifest.mf .)
echo "Built build/dist/TDDUPBridgeStandalone.jar — development test only"
