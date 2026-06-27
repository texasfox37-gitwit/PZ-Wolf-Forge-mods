# TDDUP ProjectZomboid64 Bridge Patcher

This repository hosts the **required external Java Bridge package** for **TDDUP / Till Death Do Us Part**, a Project Zomboid Build 42 mod.

The Steam Workshop item contains only Workshop-safe Lua and media files. The Workshop subscription by itself is **not enough** for the full TDDUP experience. You must also install this Java Bridge package from the official GitHub Releases page for this repository.

## Current Release

Download:

```text
TDDUP_ProjectZomboid64_BridgePatcher_v3_5_CompatMerge.zip
```

SHA256:

```text
D0F6502172EB69D51B4314148B7B0DE5215A9B54824222A014070C9F228CAAA3
```

## What This Version Adds

Version `v3.5` keeps the bridge-folder layout, installs all four current bridge jars together, and adds compatibility-merge handling for users who also run other Java-launcher mods:

```text
TDDUP_Bridges/TDDUPJavaCombatBridge.jar
TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar
TDDUP_Bridges/TDDUPFirearmAuthorityBridge.jar
TDDUP_Bridges/TDDUPPrivateBodyBridge.jar
```

The v3.5 installer preserves non-TDDUP `classpath` and `-javaagent:` entries already present in `ProjectZomboid64.json`, adds or repairs only the known TDDUP bridge entries, and writes `TDDUP_Bridge_Compatibility_Report.txt` for troubleshooting.

The included FirearmAuthority bridge is still `0.2.5-v3.4-multi-env-reinject`. It watches for Project Zomboid Lua environments and reinjects the FireAt/Ready/Status/Version globals into new environments, which is meant to fix the case where Firearm Assist later reports the bridge as missing.

## Quick Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid.
3. Download the v3.5 bridge zip from GitHub Releases.
4. Extract the whole folder somewhere easy to find, such as your Desktop.
5. Optional but recommended: run `Report_Only_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
6. Run `Install_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
7. Run `Verify_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
8. Start Project Zomboid and confirm it reaches the main menu.
9. Enable the TDDUP Workshop mod in the in-game Mods menu.
10. Restart Project Zomboid once more before loading a save.

If you install or update another mod that changes `ProjectZomboid64.json`, run the v3.5 TDDUP compatibility-merge installer again afterward. It should merge TDDUP back in without removing the other mod's Java entries.

If you do not want to use the `.bat` helper, follow [MANUAL_INSTALL.md](MANUAL_INSTALL.md).

## If Project Zomboid Will Not Launch

Do not reinstall Project Zomboid as the first fix. The bridge installer creates backups and includes remove/restore helpers.

1. Fully close Project Zomboid and Steam.
2. Run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
3. Try launching Project Zomboid again.
4. If it still does not launch, run `Restore_Latest_TDDUP_Compat_Backup_v3_5.bat`.

If the alternate launch option works but normal launch does not, treat that as a launch-configuration problem and use the remove/restore helpers before trying again.

## What The Installer Changes

The installer copies the bridge jars into a `TDDUP_Bridges` folder inside your Project Zomboid game folder and patches `ProjectZomboid64.json` so Project Zomboid loads those jars on startup. It preserves non-TDDUP Java entries, writes a compatibility report, and creates a backup before writing changes.

For the full plain-English list, see [WHAT_THIS_INSTALLER_CHANGES.md](WHAT_THIS_INSTALLER_CHANGES.md).

## Uninstall Or Restore

The package includes:

```text
Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat
Restore_Latest_TDDUP_Compat_Backup_v3_5.bat
Report_Only_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat
```

Manual uninstall steps are in [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md).

## Trust And Safety

This bridge package does not add telemetry, does not ask for Steam credentials, does not ask for GitHub tokens, does not install a background service, and does not modify save files.

Only download the bridge from the official GitHub Releases page for this repository. See [SECURITY_AND_TRUST.md](SECURITY_AND_TRUST.md) for details.

## Need Help?

Start with [TROUBLESHOOTING.md](TROUBLESHOOTING.md). If you still need help, open an issue using the install help template.
