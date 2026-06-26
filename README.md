# TDDUP ProjectZomboid64 Bridge Patcher

This repository hosts the **required external Java Bridge package** for **TDDUP / Till Death Do Us Part**, a Project Zomboid Build 42 mod.

The Steam Workshop item contains only Workshop-safe Lua and media files. The Workshop subscription by itself is **not enough** for the full TDDUP experience. You must also install this Java Bridge package from the official GitHub Releases page for this repository.

## Current Release

Download:

```text
TDDUP_ProjectZomboid64_BridgePatcher_v3_4_FirearmAuthority_MultiEnvReinject.zip
```

SHA256:

```text
DAF8125BF818493802653F3109E88594E742BD312D1C135760DB9FC1AF6F8C65
```

## What This Version Adds

Version `v3.4` keeps the bridge-folder layout and installs all four current bridge jars together:

```text
TDDUP_Bridges/TDDUPJavaCombatBridge.jar
TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar
TDDUP_Bridges/TDDUPFirearmAuthorityBridge.jar
TDDUP_Bridges/TDDUPPrivateBodyBridge.jar
```

The FirearmAuthority bridge is `0.2.5-v3.4-multi-env-reinject`. It watches for Project Zomboid Lua environments and reinjects the FireAt/Ready/Status/Version globals into new environments, which is meant to fix the case where Firearm Assist later reports the bridge as missing.

## Quick Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid.
3. Download the v3.4 bridge zip from GitHub Releases.
4. Extract the whole folder somewhere easy to find, such as your Desktop.
5. Run `Install_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
6. Run `Verify_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
7. Start Project Zomboid again.
8. Enable the TDDUP Workshop mod in the in-game Mods menu.

If you do not want to use the `.bat` helper, follow [MANUAL_INSTALL.md](MANUAL_INSTALL.md).

## What The Installer Changes

The installer copies the bridge jars into a `TDDUP_Bridges` folder inside your Project Zomboid game folder and patches `ProjectZomboid64.json` so Project Zomboid loads those jars on startup. It creates a backup before writing changes.

For the full plain-English list, see [WHAT_THIS_INSTALLER_CHANGES.md](WHAT_THIS_INSTALLER_CHANGES.md).

## Uninstall Or Restore

The package includes:

```text
Remove_TDDUP_Bridges_ProjectZomboid64_v3_4.bat
Restore_Latest_TDDUP_Backup_v3_4.bat
```

Manual uninstall steps are in [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md).

## Trust And Safety

This bridge package does not add telemetry, does not ask for Steam credentials, does not ask for GitHub tokens, does not install a background service, and does not modify save files.

Only download the bridge from the official GitHub Releases page for this repository. See [SECURITY_AND_TRUST.md](SECURITY_AND_TRUST.md) for details.

## Need Help?

Start with [TROUBLESHOOTING.md](TROUBLESHOOTING.md). If you still need help, open an issue using the install help template.
