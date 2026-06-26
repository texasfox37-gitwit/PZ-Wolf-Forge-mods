# Security

The TDDUP ProjectZomboid64 Bridge Patcher is meant to make the required Project Zomboid launch changes visible and reversible.

## It Does

- Copy four TDDUP bridge jars into `TDDUP_Bridges` inside the Project Zomboid game root.
- Patch `ProjectZomboid64.json` so the bridge jars load when Project Zomboid starts.
- Preserve `"."` and `"projectzomboid.jar"` in the classpath.
- Create backups before changing the launch file.
- Include verify, remove, and restore helpers.

## It Does Not

- No telemetry.
- No credential collection.
- No Steam login collection.
- No GitHub token collection.
- No background services.
- No save-file modification.
- No hidden auto-downloaders.

Only download the bridge from the official GitHub Releases page for this repository.
