# Security

The TDDUP ProjectZomboid64 Bridge Patcher is meant to make the required Project Zomboid launch changes visible and reversible.

## It Does

- Copy four TDDUP bridge jars into `TDDUP_Bridges` inside the Project Zomboid game root.
- Patch `ProjectZomboid64.json` so the bridge jars load when Project Zomboid starts.
- Preserve `"."` and `"projectzomboid.jar"` in the classpath.
- Preserve non-TDDUP classpath and `-javaagent:` entries already present in `ProjectZomboid64.json`.
- Create backups before changing the launch file.
- Write `TDDUP_Bridge_Compatibility_Report.txt`.
- Include report-only, verify, remove, and restore helpers.

## It Does Not

- No telemetry.
- No credential collection.
- No Steam login collection.
- No GitHub token collection.
- No background services.
- No save-file modification.
- No hidden auto-downloaders.
- No blind loading of every `.jar` found on the machine.

Only download the bridge from the official GitHub Releases page for this repository.
