# Security And Trust

This page explains what the TDDUP Public Java Bridge package does and does not do.

## What The Installer Does

- Checks that the two public TDDUP bridge jars are present before changing anything.
- Finds your Project Zomboid game folder when the extracted bridge folder is inside the Project Zomboid main folder.
- Copies `TDDUPJavaCombatBridge.jar` and `TTDUP_NPC_RenderBridge.jar` into `TDDUP_Bridges` inside the Project Zomboid game folder.
- Removes managed TDDUP Java launch entries from `ProjectZomboid64.json`.
- Preserves other mods' non-TDDUP classpath and `-javaagent:` entries already present in `ProjectZomboid64.json`.
- Creates a backup before repairing `ProjectZomboid64.json`.
- Includes `installer.bat`, `uninstaller.bat`, `Launch_TDDUP_Bridge_Alternate.bat`, `README.txt`, and the two required public jars.

## What The Direct Launcher Does

- Starts Project Zomboid through Project Zomboid's bundled `jre64` Java runtime.
- Loads `TDDUPJavaCombatBridge.jar` and `TTDUP_NPC_RenderBridge.jar` as Java agents.
- Does not install files.
- Does not copy files.
- Does not delete files.
- Does not edit `ProjectZomboid64.json`.

## Current Public Bridge Jars

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

This public package does not include FirearmAuthority, private body bridge jars, or DirectFire test jars.

## What The Package Does Not Do

- No telemetry.
- No analytics.
- No auto-downloaders.
- No background services.
- No Steam credential collection.
- No GitHub token collection.
- No personal credential collection.
- No save-file modification.
- No server-save modification.
- No Steam client modification.
- No hidden remote payload download.

## Download Safety

Only download the bridge from the official GitHub Releases page for this repository.

Do not download bridge installers from random file mirrors, Discord reposts, or reuploaded archives unless the TDDUP maintainers explicitly point you there.

Before installing, the published `SHA256SUMS.txt` should match the zip attached to the GitHub Release.

## Antivirus Notes

Some antivirus tools warn about `.bat` scripts because scripts can change local files. In this package, the installer copies two bridge jars and repairs TDDUP launch entries in Project Zomboid's launch configuration.

If you are not comfortable running `installer.bat`, use [MANUAL_INSTALL.md](MANUAL_INSTALL.md) instead.
