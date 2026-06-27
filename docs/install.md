# Install

The Java Bridge is required. Steam Workshop subscription alone is not enough.

## Standard Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid.
3. Download `TDDUP_ProjectZomboid64_BridgePatcher_v3_5_CompatMerge.zip` from GitHub Releases.
4. Extract the whole zip folder.
5. Optional but recommended: run `Report_Only_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
6. Run `Install_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
7. Run `Verify_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
8. Start Project Zomboid and confirm it reaches the main menu.
9. Enable TDDUP in the in-game Mods menu.
10. Restart Project Zomboid once more before loading a save.

## What The Installer Does

The installer copies four bridge jars into `TDDUP_Bridges` inside your Project Zomboid game folder and updates `ProjectZomboid64.json` so Project Zomboid loads them on startup.

It creates a backup before changing files, preserves non-TDDUP Java entries, preserves `"."` plus `"projectzomboid.jar"` in the classpath, and writes `TDDUP_Bridge_Compatibility_Report.txt`.

## If You Use Other Java Mods

If you install or update another mod that changes `ProjectZomboid64.json`, run the v3.5 TDDUP compatibility-merge installer again afterward. It should merge TDDUP back in without removing the other mod's Java entries.

## Manual Install

If you do not want to use the `.bat` helper, follow the root repository guide: [Manual Install](../MANUAL_INSTALL.md).

## If The Game Will Not Launch

Do not reinstall Project Zomboid as the first fix. Run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat` first. If that does not restore normal launch, run `Restore_Latest_TDDUP_Compat_Backup_v3_5.bat`.

If alternate launch works but normal launch does not, the launch configuration is the likely problem.
