# Install

The Java Bridge is required. Steam Workshop subscription alone is not enough.

## Standard Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid.
3. Download `TDDUP_ProjectZomboid64_BridgePatcher_v3_4_FirearmAuthority_MultiEnvReinject.zip` from GitHub Releases.
4. Extract the whole zip folder.
5. Run `Install_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
6. Run `Verify_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
7. Start Project Zomboid again.
8. Enable TDDUP in the in-game Mods menu.

## What The Installer Does

The installer copies four bridge jars into `TDDUP_Bridges` inside your Project Zomboid game folder and updates `ProjectZomboid64.json` so Project Zomboid loads them on startup.

It creates a backup before changing files and preserves `"."` plus `"projectzomboid.jar"` in the classpath.

## Manual Install

If you do not want to use the `.bat` helper, follow the root repository guide: [Manual Install](../MANUAL_INSTALL.md).
