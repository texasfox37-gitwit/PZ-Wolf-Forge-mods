# Troubleshooting

## TDDUP Says Java Bridge Missing

The Workshop mod may be installed, but the required GitHub Java Bridge is not loading.

Fully close Project Zomboid and Steam, install the GitHub bridge package, then start the game again.

## Project Zomboid Was Open During Install

Close Project Zomboid completely and run `installer.bat` again. The game reads its launch configuration when it starts.

## Project Zomboid Will Not Launch After Install

Do not reinstall Project Zomboid as the first fix.

1. Fully close Project Zomboid and Steam.
2. Run `uninstaller.bat` from the extracted bridge folder.
3. Try launching Project Zomboid again.

If Steam's Alternate Launch works but TDDUP says the Java Bridge is missing, Alternate Launch may be bypassing the patched `ProjectZomboid64.json`.

After running `installer.bat`, try:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

This fallback launcher does not install or change files. It starts Project Zomboid with the two public bridge jars loaded through Project Zomboid's bundled Java runtime.

## Antivirus Warning

Some antivirus tools warn about `.bat` helper scripts. The scripts in this package copy two bridge jars and update Project Zomboid's launch configuration.

If you do not want to run them, use [Manual Install](../MANUAL_INSTALL.md).

## Game Update Reset The Launch File

If a Project Zomboid update overwrote `ProjectZomboid64.json`, close the game and run `installer.bat` again.

## Another Java Mod Also Changes ProjectZomboid64.json

Run `installer.bat` again after the other Java mod is installed. The v3.6.1 installer preserves non-TDDUP Java entries that are already in `ProjectZomboid64.json`.

Do not auto-load every `.jar` you find. Some jars are libraries, not Java agents, and blindly loading them can cause crashes.

## Fully Remove The Bridge

Run `uninstaller.bat`, or follow [Manual Uninstall](../MANUAL_UNINSTALL.md).

## Workshop Installed But GitHub Bridge Missing

Install the required GitHub bridge too. The Workshop item does not include the external Java Bridge package.
