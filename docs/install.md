# Install

The Java Bridge is required. Steam Workshop subscription alone is not enough.

## Standard Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid and Steam.
3. Download `TDDUP_Public_JavaBridge_v3_6_SIMPLE_TWO_JAR.zip` from GitHub Releases.
4. Extract the whole zip folder into your Project Zomboid main folder.
5. Open the extracted folder.
6. Run `installer.bat`.
7. Start Project Zomboid and confirm it reaches the main menu.
8. Enable TDDUP in the in-game Mods menu.
9. Restart Project Zomboid once more before loading a save.

## What The Installer Does

The installer copies two public bridge jars into `TDDUP_Bridges` inside your Project Zomboid game folder and updates `ProjectZomboid64.json` so Project Zomboid loads them on startup.

It creates a backup before changing files, preserves other mods' non-TDDUP Java entries, preserves `"."` plus `"projectzomboid.jar"` in the classpath, and preserves memory settings such as `-Xmx`.

## If You Use Other Java Mods

If you install or update another mod that changes `ProjectZomboid64.json`, run `installer.bat` again afterward. It should add the two TDDUP public bridge jars back in without removing the other mod's Java entries.

Do not auto-load every `.jar` you find. Some jars are libraries, not Java agents, and blindly loading them can cause crashes.

## Manual Install

If you do not want to use the `.bat` helper, follow the root repository guide: [Manual Install](../MANUAL_INSTALL.md).

## If The Game Will Not Launch

Do not reinstall Project Zomboid as the first fix. Run `uninstaller.bat` from the extracted bridge folder first.

If alternate launch works but normal launch does not, the launch configuration is the likely problem.
