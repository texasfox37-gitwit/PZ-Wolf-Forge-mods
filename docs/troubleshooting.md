# Troubleshooting

## TDDUP Says Java Bridge Missing

The Workshop mod may be installed, but the required GitHub Java Bridge is not loading.

Fully close Project Zomboid, install the GitHub bridge package, run the verify helper, then start the game again.

## Project Zomboid Was Open During Install

Close Project Zomboid completely and run the installer again. The game reads its launch configuration when it starts.

## Antivirus Warning

Some antivirus tools warn about `.bat` or `.ps1` helper scripts. The scripts in this package copy bridge jars and update Project Zomboid's launch configuration.

If you do not want to run them, use [Manual Install](../MANUAL_INSTALL.md).

## Game Update Reset The Launch File

If a Project Zomboid update overwrote `ProjectZomboid64.json`, close the game and run `Install_TDDUP_Bridges_ProjectZomboid64_v3_4.bat` again.

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

Run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`, or follow [Manual Uninstall](../MANUAL_UNINSTALL.md).

## Workshop Installed But GitHub Bridge Missing

Install the required GitHub bridge too. The Workshop item does not include the external Java Bridge package.
