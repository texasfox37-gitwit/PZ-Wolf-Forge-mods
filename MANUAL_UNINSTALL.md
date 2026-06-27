# Manual Uninstall

Use this only if you do not want to run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.

## 1. Close Project Zomboid

Fully exit Project Zomboid before editing launch files.

If Project Zomboid will not launch after installing the bridge, try `Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat` or `Restore_Latest_TDDUP_Compat_Backup_v3_5.bat` before manually editing files.

## 2. Back Up ProjectZomboid64.json

Make a copy of:

```text
ProjectZomboid64.json
```

Name the copy something clear, such as:

```text
ProjectZomboid64.json.backup_before_TDDUP_v3_5_compat_merge_removal
```

## 3. Remove Bridge Launch Entries

Open `ProjectZomboid64.json`.

From `vmArgs`, remove entries matching:

```json
"-javaagent:TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"-javaagent:TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
"-javaagent:TDDUP_Bridges/TDDUPFirearmAuthorityBridge.jar"
"-javaagent:TDDUP_Bridges/TDDUPPrivateBodyBridge.jar"
```

Also remove older TDDUP, TTDUP, WolfBond, WolfCompanion, or NPC render bridge `-javaagent` entries if they are present. Leave other mods' `-javaagent` entries alone.

## 4. Remove Bridge Classpath Entries

From `classpath`, remove:

```json
"TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
"TDDUP_Bridges/TDDUPFirearmAuthorityBridge.jar"
"TDDUP_Bridges/TDDUPPrivateBodyBridge.jar"
```

Leave other mods' classpath entries alone.

Keep or restore normal Project Zomboid base entries:

```json
"."
"projectzomboid.jar"
```

## 5. Optional File Cleanup

From the Project Zomboid game root, delete the `TDDUP_Bridges` folder if it contains only TDDUP bridge jars.

Leave normal Project Zomboid files alone.

## 6. Start Project Zomboid

Start Project Zomboid once without the bridge to confirm the game still opens.
