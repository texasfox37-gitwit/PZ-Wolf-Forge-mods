# HF84.2 direct-launch scripts (B42.22.2 candidate)

**No modifications to ProjectZomboid64.json or projectzomboid.jar.** Extract the packaged files into the Project Zomboid game folder, beside `projectzomboid.jar`. Run `RUN_TDDUP.bat` (standalone default) or `RUN_TDDUP_ZOMBIEBUDDY.bat` (explicitly request ZombieBuddy).

The shared launcher is `_TDDUP_Launch_Common.cmd`. The downloadable ChatGPT HF84.2 launcher ZIP contains the already compiled **HF84.1 P4** `TDDUP_Bridges/TDDUPBridgeStandalone.jar`; that binary is deliberately **not in this draft source branch** until the inherited bytecode's licensing and redistributability are confirmed. The user's old `BRIDGE (1)(1).zip` was used only as the **launch-pattern reference**. Do not ship its earlier A7 JAR on B42.22.2.

When ZombieBuddy is explicitly requested, the launcher checks for its Java agent JAR in the game folder or the official Workshop directory, and falls back to standalone if absent. It does **not** auto-select ZombieBuddy by presence in normal mode. ZB v2.3.4 may load itself without loading TDDUP Java mods on B42.22.2; pre-launch discovery is not proof it works.

These BATs bypass Java options stored in the game's JSON, including any other agents configured only there. They override inherited `JAVA_TOOL_OPTIONS`, `JDK_JAVA_OPTIONS`, and `_JAVA_OPTIONS` within the launched process. Additional Java-agent mods require an intentionally designed combined direct-launch script.

Both host choices need the **HF84.2 dual-host mod** installed. Standalone: enable TDDUPUnified. ZombieBuddy: also enable ZombieBuddy and TDDUPZBFullBridge. The launcher chooses **one** JVM agent per run.

Development status: static scripts and Java agent smoke-tested; not yet executed through Windows cmd.exe on B42.22.2. Preserve public v3.6.3 until users verify both modes.
