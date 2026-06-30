# Security

The TDDUP Public Java Bridge package is meant to make the required Project Zomboid launch path visible and reversible.

## It Does

- Copy two public TDDUP bridge jars into `TDDUP_Bridges` inside the Project Zomboid game root.
- Remove managed TDDUP Java launch entries from `ProjectZomboid64.json`.
- Preserve other mods' non-TDDUP classpath and `-javaagent:` entries already present in `ProjectZomboid64.json`.
- Create a backup before repairing the launch file.
- Include `README.txt`, `installer.bat`, `uninstaller.bat`, `Launch_TDDUP_Bridge_Alternate.bat`, and the two public bridge jars.

## Direct Launcher

`Launch_TDDUP_Bridge_Alternate.bat` starts Project Zomboid through Project Zomboid's bundled Java runtime with the two public bridge jars loaded.

It does not install, copy, delete, or edit files.

## It Does Not

- No telemetry.
- No credential collection.
- No Steam login collection.
- No GitHub token collection.
- No background services.
- No save-file modification.
- No hidden auto-downloaders.
- No blind loading of every `.jar` found on the machine.
- No FirearmAuthority, private body bridge, or DirectFire test jars in this public package.

Only download the bridge from the official GitHub Releases page for this repository.
