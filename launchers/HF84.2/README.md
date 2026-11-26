# TDDUP HF84.2 No-JSON BAT Launcher — B42.22.2 candidate

This folder contains the **published launch-script source** for the optional TDDUP HF84.2 dual-host Java launcher. It is compatible with the **HF90** Workshop gameplay mod because the bridge and BAT launcher did not change during the HF85–HF90 gameplay iterations.

**ZombieBuddy users:** Use **normal Steam Play** instead of these BAT files. The HF91 Build 42.22.2 test confirmed ZombieBuddy discovering `TDDUPZBFullBridge` and injecting the required Java/Lua functions before new-save spouse creation. Enable the main TDDUP mod and hosted bridge, and approve Java loading if ZombieBuddy prompts you. This is the simpler recommended path when ZombieBuddy is working.

**Players without ZombieBuddy:** This optional standalone BAT launcher remains useful; it provides the HF84.1 collision-repaired Java agent without changing `ProjectZomboid64.json`.

**The compiled bridge JAR is NOT contained in these GitHub source files.** To give players the one-step installer, publish the separately prepared ZIP (`TDDUP_HF84_2_NoJSON_BAT_Launcher.zip`) as an asset under a **pre-release** in this repository. Until that ZIP is attached, do **not** instruct players to download source code as a complete launcher.

## Optional standalone installation (without ZombieBuddy)

1. Close Project Zomboid and back up the save.
2. Download `TDDUP_HF84_2_NoJSON_BAT_Launcher.zip` from the official GitHub Releases page.
3. Extract the ZIP into the main Project Zomboid game folder, beside `projectzomboid.jar`.
4. Subscribe to and enable the matching **HF90 TDDUP Workshop** mod.
5. Double-click `RUN_TDDUP.bat` for the standalone bridge. You need no JSON changes and no JAR modification.

## Included BAT scripts

| File | Purpose |
|---|---|
| `RUN_TDDUP.bat` | Recommended standalone bridge host |
| `RUN_TDDUP_DEBUG.bat` | Standalone host with debug diagnostics |
| `RUN_TDDUP_ZOMBIEBUDDY.bat` | Explicit ZombieBuddy-host choice; falls back to standalone if its JAR is missing |
| `RUN_TDDUP_ZB_DEBUG.bat` | ZombieBuddy mode with diagnostics |
| `_TDDUP_Launch_Common.cmd` | Shared launcher logic; must sit beside the BAT files |

The distribution ZIP additionally contains `README_FIRST.txt`, `TDDUP_Bridges/TDDUPBridgeStandalone.jar`, and `TDDUP_Bridges/SHA256.txt`.

## Important limitations

- This launcher **does not read or edit** `ProjectZomboid64.json`.
- It selects one Java agent per invocation. Any **other** Java agents installed only in `ProjectZomboid64.json` will be skipped when starting through these BATs.
- For ZombieBuddy users, normal Steam Play is preferred after confirming the TDDUP Java module actually loads; simply detecting the ZombieBuddy JAR is not proof of TDDUP compatibility. For users without ZombieBuddy, use the standalone BAT option.
- The older A7 P4 bridge JAR must **not** be substituted for the HF84.1 patched standalone JAR in the distribution ZIP.
- This is a Build 42.22.2 *candidate*, not a fully validated stable release.
- Review the legacy JAR's bundled code and ASM license obligations before public redistribution.

## Integrity

SHA-256 of the staged full package:

`32721406ea9fd6a7eb708c0b5504e256a060c1b7ca996ed85ef557f21d97ad23`

SHA-256 of the bundled `TDDUP_Bridges/TDDUPBridgeStandalone.jar`:

`5950f6d6dc81d108d57d4a07483218563a7045faafac6a726a89e3ce213d003f`

The prepared ZIP passed local ZIP integrity testing; this does not establish Windows/game runtime compatibility or a security audit.
