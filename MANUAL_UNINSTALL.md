# Manual Uninstall

Use this only if you do not want to run `uninstaller.bat`.

## 1. Close Project Zomboid

Fully exit Project Zomboid and Steam before editing launch files.

If Project Zomboid will not launch after installing the bridge, try `uninstaller.bat` from the extracted bridge folder before manually editing files.

## 2. Restore A Backup If Available

If the installer made a backup, it will look similar to:

```text
ProjectZomboid64.json.bak_TDDUPPublicBridge_YYYYMMDD_HHMMSS
```

The simplest manual uninstall is to copy the newest matching backup over:

```text
ProjectZomboid64.json
```

## 3. Or Remove Bridge Launch Entries By Hand

If you do not have a backup, open `ProjectZomboid64.json`.

From `vmArgs`, remove entries matching:

```json
"-javaagent:TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"-javaagent:TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
```

Also remove older TDDUP, TTDUP, FirearmAuthority, private body bridge, DirectFire, WolfBond, WolfCompanion, or NPC render bridge `-javaagent` entries if they are present. Leave other mods' `-javaagent` entries alone.

## 4. Remove Bridge Classpath Entries

From `classpath`, remove:

```json
"TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
```

Leave other mods' classpath entries alone.

Keep or restore normal Project Zomboid base entries:

```json
"."
"projectzomboid.jar"
```

## 5. Optional File Cleanup

From the Project Zomboid game root, delete these files if they are still present:

```text
TDDUP_Bridges\TDDUPJavaCombatBridge.jar
TDDUP_Bridges\TTDUP_NPC_RenderBridge.jar
```

Delete the `TDDUP_Bridges` folder only if it is empty.

## 6. Start Project Zomboid

Start Project Zomboid once without the bridge to confirm the game still opens.
