# Security

The TDDUP Java Bridge installer is meant to make the required Project Zomboid launch changes visible and reversible.

## It Does

- Copy `TDDUPJavaCombatBridge.jar` to the Project Zomboid game root.
- Copy `TTDUP_NPC_RenderBridge.jar` to the Project Zomboid game root.
- Patch `ProjectZomboid64.json` so the bridge loads when Project Zomboid starts.
- Create backups before changing the launch file.
- Include an uninstall path that removes bridge launch entries, bridge classpath entries, TDDUP bridge jars, and the install manifest.

## It Does Not

- No telemetry.
- No credential collection.
- No Steam login collection.
- No GitHub token collection.
- No background services.
- No save-file modification.
- No hidden auto-downloaders.
- No generic Java DLL copying by default.

Only download the bridge from the official GitHub Releases page for this repository.
