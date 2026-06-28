# Troubleshooting

## Steam Workshop Mod Loads But TDDUP Says Java Bridge Missing

This means the Workshop mod is installed, but the required GitHub Java Bridge is not loading.

Try this:

1. Fully close Project Zomboid and Steam.
2. Download `TDDUP_Public_JavaBridge_v3_6_1_WITH_ALT_LAUNCHER.zip` from the official GitHub Releases page.
3. Extract the whole folder into your Project Zomboid main folder.
4. Open the extracted folder.
5. Run `installer.bat`.
6. Start Project Zomboid again.

Workshop subscription alone is not enough.

## I Installed The Bridge While Project Zomboid Was Open

Close Project Zomboid completely, then run `installer.bat` again.

Project Zomboid reads its launch configuration when it starts. If the game was already open, it may not see the bridge until the next full restart.

## Project Zomboid Will Not Launch After Running The Installer

Do not reinstall Project Zomboid as the first fix.

Try this:

1. Fully close Project Zomboid and Steam.
2. Open the extracted bridge folder.
3. Run `uninstaller.bat`.
4. Start Project Zomboid again.

If Steam's Alternate Launch works but normal launch does not, remember that Alternate Launch may bypass `ProjectZomboid64.json` and open the game without the Java Bridge.

For this case, v3.6.1 includes:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

Use it only after running `installer.bat`. It does not install or change files; it starts Project Zomboid with the two public TDDUP bridge jars loaded through Project Zomboid's bundled Java runtime.

If this happens, please report it with:

```text
console.txt
ProjectZomboid64.json
the newest ProjectZomboid64.json.bak_TDDUPPublicBridge_* backup name
```

## Antivirus Warns About Scripts

The package includes `installer.bat` and `uninstaller.bat`. Some antivirus tools warn about scripts because scripts can change local files.

In this package, the scripts copy two TDDUP bridge jars into `TDDUP_Bridges` and patch `ProjectZomboid64.json` so Project Zomboid loads them. They do not collect credentials, install a service, or download extra payloads.

## A Game Update Overwrote ProjectZomboid64.json

Project Zomboid or Steam updates may replace or reset `ProjectZomboid64.json`.

If TDDUP worked before and now says the bridge is missing:

1. Fully close Project Zomboid.
2. Run `installer.bat` again from the extracted bridge folder.
3. Start Project Zomboid again.

## Another Java Mod Also Changes ProjectZomboid64.json

Run this installer again after installing or updating another Java-launcher mod.

The installer preserves non-TDDUP `classpath` and `-javaagent:` entries already present in `ProjectZomboid64.json`. It does not auto-load every `.jar` it finds, because that can cause more crashes.

If users report CTDs with multiple Java mods, ask for:

```text
ProjectZomboid64.json
console.txt
```

## Steam Alternate Launch Works But TDDUP Says Bridge Missing

Steam's Alternate Launch can open Project Zomboid without loading the GitHub Java Bridge.

Run `installer.bat` first. Then, if normal launch still fails but Alternate Launch opens without the bridge, try:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

This is a fallback launcher, not an installer. It does not edit files.

## I Want To Fully Remove The Bridge

Run:

```text
uninstaller.bat
```

from the extracted bridge folder.

## I Installed The Workshop Item But Not The GitHub Bridge

Install the GitHub bridge too. The TDDUP Workshop item intentionally does not include the external Java Bridge package.
