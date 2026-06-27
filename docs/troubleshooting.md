# Troubleshooting

## TDDUP Says Java Bridge Missing

The Workshop mod may be installed, but the required GitHub Java Bridge is not loading.

Fully close Project Zomboid, install the GitHub bridge package, run the verify helper, then start the game again.

## Project Zomboid Was Open During Install

Close Project Zomboid completely and run the installer again. The game reads its launch configuration when it starts.

## Project Zomboid Will Not Launch After Install

Do not reinstall Project Zomboid as the first fix.

1. Fully close Project Zomboid and Steam.
2. Run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
3. Try launching Project Zomboid again.
4. If it still will not launch, run `Restore_Latest_TDDUP_Compat_Backup_v3_5.bat`.

If alternate launch works but normal launch does not, the normal `ProjectZomboid64.json` launch configuration is the likely problem.

## Antivirus Warning

Some antivirus tools warn about `.bat` or `.ps1` helper scripts. The scripts in this package copy bridge jars and update Project Zomboid's launch configuration.

If you do not want to run them, use [Manual Install](../MANUAL_INSTALL.md).

## Game Update Reset The Launch File

If a Project Zomboid update overwrote `ProjectZomboid64.json`, close the game and run `Install_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat` again.

## Another Java Mod Also Changes ProjectZomboid64.json

Run `Report_Only_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat` first. It writes `TDDUP_Bridge_Compatibility_Report.txt` without changing the launch file.

Then run `Install_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat` again. The v3.5 compatibility-merge installer preserves non-TDDUP Java entries that are already in `ProjectZomboid64.json`.

Do not auto-load every `.jar` you find. Some jars are libraries, not Java agents, and blindly loading them can cause crashes.

## FirearmAuthority Does Not Enter Premain

Look in `console.txt` for:

```text
[TDDUPFirearmAuthorityBridge 0.2.5-v3.4-multi-env-reinject] ENTER premain
```

If that line is missing, Project Zomboid is not starting the FirearmAuthority javaagent.

## FirearmAuthority Enters Premain But Does Not Inject

Look for:

```text
direct-rawset SUCCESS
```

If it is missing, collect `console.txt` and `TDDUP_FirearmAuthority_RuntimeDiagnostic_v3_4.txt`.

## Fully Remove The Bridge

Run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`, or follow [Manual Uninstall](../MANUAL_UNINSTALL.md).

## Workshop Installed But GitHub Bridge Missing

Install the required GitHub bridge too. The Workshop item does not include the external Java Bridge package.
