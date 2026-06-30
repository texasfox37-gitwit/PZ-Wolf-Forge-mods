# Manual Uninstall

Use this only if you do not want to run `uninstaller.bat`.

## 1. Close Project Zomboid

Fully exit Project Zomboid and Steam before editing launch files.

Do not restore the newest `ProjectZomboid64.json.bak_TDDUP...` file as the first fix. Some backups were created after TDDUP entries already existed, so they can re-add the same broken launch entries.

## 2. Remove TDDUP Launch Entries

Open `ProjectZomboid64.json`.

From `vmArgs`, remove entries matching:

```json
"-javaagent:TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"-javaagent:TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
```

Also remove older TDDUP, TTDUP, FirearmAuthority, private body bridge, DirectFire, WolfBond, WolfCompanion, or NPC render bridge `-javaagent` entries if they are present. Leave other mods' `-javaagent` entries alone.

## 3. Remove TDDUP Classpath Entries

From `classpath`, remove:

```json
"TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
```

Leave other mods' classpath entries alone.

Keep normal Project Zomboid base entries:

```json
"."
"projectzomboid.jar"
```

## 4. Optional File Cleanup

From the Project Zomboid game root, delete these files if they are still present:

```text
TDDUP_Bridges\TDDUPJavaCombatBridge.jar
TDDUP_Bridges\TTDUP_NPC_RenderBridge.jar
```

Delete the `TDDUP_Bridges` folder only if it is empty.

## 5. Start Project Zomboid

Start Project Zomboid once without the bridge to confirm the game still opens.

## Need A True Vanilla Launcher File?

Use Steam's **Verify integrity of game files** option for Project Zomboid.

That is safer than using a bundled vanilla copy, because Project Zomboid may change `ProjectZomboid64.json` between updates.
