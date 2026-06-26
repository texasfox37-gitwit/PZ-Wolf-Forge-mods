# Troubleshooting

## Steam Workshop Mod Loads But TDDUP Says Java Bridge Missing

This means the Workshop mod is installed, but the required GitHub Java Bridge is not loading.

Try this:

1. Fully close Project Zomboid.
2. Download the v3.4 bridge zip from the official GitHub Releases page.
3. Extract the whole folder.
4. Run `Install_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
5. Run `Verify_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
6. Start Project Zomboid again.

Workshop subscription alone is not enough.

## I Installed The Bridge While Project Zomboid Was Open

Close Project Zomboid completely, then run the installer again.

Project Zomboid reads its launch configuration when it starts. If the game was already open, it may not see the bridge until the next full restart.

## Antivirus Warns About Scripts

The package includes `.bat` and `.ps1` helper scripts. Some antivirus tools warn about scripts because scripts can change local files.

In this package, the scripts copy bridge jars into `TDDUP_Bridges` and patch `ProjectZomboid64.json` so Project Zomboid loads them. They do not collect credentials, install a service, or download extra payloads.

If you do not want to run the helper scripts, follow [MANUAL_INSTALL.md](MANUAL_INSTALL.md).

## A Game Update Overwrote ProjectZomboid64.json

Project Zomboid or Steam updates may replace or reset `ProjectZomboid64.json`.

If TDDUP worked before and now says the bridge is missing:

1. Fully close Project Zomboid.
2. Run `Install_TDDUP_Bridges_ProjectZomboid64_v3_4.bat` again.
3. Run `Verify_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
4. Start Project Zomboid again.

## FirearmAuthority Does Not Enter Premain

Look in `console.txt` for:

```text
[TDDUPFirearmAuthorityBridge 0.2.5-v3.4-multi-env-reinject] ENTER premain
```

If that line is missing, Project Zomboid is not starting the FirearmAuthority javaagent. Reinstall the v3.4 bridge package and verify `ProjectZomboid64.json`.

## FirearmAuthority Enters Premain But Does Not Inject

Look for:

```text
direct-rawset SUCCESS
```

If `ENTER premain` appears but `direct-rawset SUCCESS` does not, collect `console.txt` and:

```text
TDDUP_FirearmAuthority_RuntimeDiagnostic_v3_4.txt
```

## Firearm Assist Still Says Bridge Missing

Use the v3.4 Multi Env Reinject package. It continuously watches `LuaManager.env` and reinjects FireAt/Ready/Status/Version globals into new Lua environments.

## I Want To Fully Remove The Bridge

Run:

```text
Remove_TDDUP_Bridges_ProjectZomboid64_v3_4.bat
```

Or follow [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md).

## I Installed The Workshop Item But Not The GitHub Bridge

Install the GitHub bridge too. The TDDUP Workshop item intentionally does not include the external Java Bridge package.

Download the required bridge zip from GitHub Releases, close Project Zomboid, and run the installer.
