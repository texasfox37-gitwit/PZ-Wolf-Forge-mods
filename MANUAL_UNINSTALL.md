# Manual Uninstall

Use this if you do not want to run `REMOVE_TDDUP_JAVA_AGENTS.bat`.

## 1. Close Project Zomboid

Fully exit Project Zomboid before editing launch files.

## 2. Back Up ProjectZomboid64.json

Make a copy of:

```text
ProjectZomboid64.json
```

Name the copy something clear, such as:

```text
ProjectZomboid64.json.backup_before_TDDUP_bridge_removal
```

## 3. Remove Bridge Launch Entries

Open `ProjectZomboid64.json`.

From `vmArgs`, remove these entries:

```json
"-javaagent:TDDUPJavaCombatBridge.jar",
"-javaagent:TTDUP_NPC_RenderBridge.jar"
```

Also remove older duplicate TDDUP, WolfBond, WolfCompanion, or NPC render bridge `-javaagent` entries if they are present.

## 4. Remove The Bridge Classpath Entry

From `classpath`, remove:

```json
"TDDUPJavaCombatBridge.jar"
```

Keep normal Project Zomboid entries such as:

```json
"projectzomboid.jar"
```

## 5. Optional File Cleanup

From the Project Zomboid game root folder, delete:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

Leave normal Project Zomboid files alone.

## 6. Start Project Zomboid

Start Project Zomboid once without the bridge. If the game starts normally, the bridge launch entries have been removed.
