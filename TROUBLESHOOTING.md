# Troubleshooting

## Steam Workshop Mod Loads But TDDUP Says Java Bridge Missing

This means the Workshop mod is installed, but the required GitHub Java Bridge is not loading.

Try this:

1. Fully close Project Zomboid.
2. Download the v3.5 bridge zip from the official GitHub Releases page.
3. Extract the whole folder.
4. Run `Report_Only_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
5. Run `Install_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
6. Run `Verify_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
7. Start Project Zomboid again.

Workshop subscription alone is not enough.

## I Installed The Bridge While Project Zomboid Was Open

Close Project Zomboid completely, then run the installer again.

Project Zomboid reads its launch configuration when it starts. If the game was already open, it may not see the bridge until the next full restart.

## Project Zomboid Will Not Launch After Running The Installer

Do not reinstall Project Zomboid as the first fix. The bridge patcher creates backups and includes removal tools.

Try this:

1. Fully close Project Zomboid and Steam.
2. Run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
3. Start Project Zomboid again.
4. If it still will not launch, run `Restore_Latest_TDDUP_Compat_Backup_v3_5.bat`.
5. Start Project Zomboid again.

If the alternate launch option works but normal launch does not, that strongly suggests the normal `ProjectZomboid64.json` launch configuration needs to be removed or restored.

If this happens, please report it with:

```text
console.txt
ProjectZomboid64.json
the newest ProjectZomboid64.json.bak_TDDUPCompatMerge_* backup name
TDDUP_Bridge_Compatibility_Report.txt
```

## Antivirus Warns About Scripts

The package includes `.bat` and `.ps1` helper scripts. Some antivirus tools warn about scripts because scripts can change local files.

In this package, the scripts copy bridge jars into `TDDUP_Bridges` and patch `ProjectZomboid64.json` so Project Zomboid loads them. They do not collect credentials, install a service, or download extra payloads.

If you do not want to run the helper scripts, follow [MANUAL_INSTALL.md](MANUAL_INSTALL.md).

## A Game Update Overwrote ProjectZomboid64.json

Project Zomboid or Steam updates may replace or reset `ProjectZomboid64.json`.

If TDDUP worked before and now says the bridge is missing:

1. Fully close Project Zomboid.
2. Run `Install_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat` again.
3. Run `Verify_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
4. Start Project Zomboid again.

## Another Java Mod Updated Or Also Changes ProjectZomboid64.json

Run the v3.5 compatibility-merge installer again after installing or updating another Java-launcher mod.

The v3.5 installer is designed to preserve non-TDDUP `classpath` and `-javaagent:` entries that are already in `ProjectZomboid64.json`. It does not auto-load every `.jar` it finds, because that can cause more crashes.

If users report CTDs with multiple Java mods, ask for:

```text
ProjectZomboid64.json
TDDUP_Bridge_Compatibility_Report.txt
console.txt
```

## FirearmAuthority Does Not Enter Premain

Look in `console.txt` for:

```text
[TDDUPFirearmAuthorityBridge 0.2.5-v3.4-multi-env-reinject] ENTER premain
```

If that line is missing, Project Zomboid is not starting the FirearmAuthority javaagent. Reinstall the v3.5 compatibility-merge bridge package and verify `ProjectZomboid64.json`.

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

Use the v3.5 Compatibility Merge package. It still includes the Multi Env Reinject FirearmAuthority jar, and it preserves other Java mod entries in `ProjectZomboid64.json`.

If the verify helper passes but the spouse is invisible or Firearm Assist still reports the bridge as missing, do not keep reinstalling the bridge. Launch once, collect `console.txt`, and check for the FirearmAuthority lines above. That is a runtime/debugging problem, not proof that Steam Workshop alone is enough.

## I Want To Fully Remove The Bridge

Run:

```text
Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat
```

Or follow [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md).

## I Installed The Workshop Item But Not The GitHub Bridge

Install the GitHub bridge too. The TDDUP Workshop item intentionally does not include the external Java Bridge package.

Download the required bridge zip from GitHub Releases, close Project Zomboid, and run the installer.
