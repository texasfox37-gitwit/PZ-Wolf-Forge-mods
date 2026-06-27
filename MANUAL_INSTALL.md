# Manual Install

Use this only if you do not want to run `Install_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.

The bridge is still required. Manual install only replaces the helper script with steps you do yourself.

## 1. Close Project Zomboid

Fully exit Project Zomboid before changing files.

## 2. Find Your Project Zomboid Game Folder

You are looking for the folder that contains:

```text
ProjectZomboid64.json
projectzomboid.jar
ProjectZomboid64.exe
```

Common Steam location:

```text
C:\Program Files (x86)\Steam\steamapps\common\ProjectZomboid
```

Your Steam library may be on another drive.

## 3. Back Up ProjectZomboid64.json

Make a copy of:

```text
ProjectZomboid64.json
```

Name the copy something clear, such as:

```text
ProjectZomboid64.json.backup_before_TDDUP_v3_5_compat_merge
```

## 4. Create The Bridge Folder

Inside the Project Zomboid game folder, create:

```text
TDDUP_Bridges
```

## 5. Copy The Bridge Jars

From the extracted GitHub Release package, copy these files into `TDDUP_Bridges`:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
TDDUPFirearmAuthorityBridge.jar
TDDUPPrivateBodyBridge.jar
```

## 6. Patch ProjectZomboid64.json

Open `ProjectZomboid64.json` in a plain text editor.

In the `classpath` list, keep existing non-TDDUP entries and make sure these entries exist exactly once:

```json
"."
"projectzomboid.jar"
"TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
"TDDUP_Bridges/TDDUPFirearmAuthorityBridge.jar"
"TDDUP_Bridges/TDDUPPrivateBodyBridge.jar"
```

In the `vmArgs` list, keep existing non-TDDUP entries and make sure these entries exist exactly once:

```json
"-javaagent:TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"-javaagent:TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
"-javaagent:TDDUP_Bridges/TDDUPFirearmAuthorityBridge.jar"
"-javaagent:TDDUP_Bridges/TDDUPPrivateBodyBridge.jar"
```

Remove older duplicate TDDUP, TTDUP, WolfBond, WolfCompanion, or NPC render bridge entries if they are present.

Do not add every `.jar` you find to `classpath` or `vmArgs`. Some jars are libraries, not Java agents, and blindly loading them can cause crashes.

## 7. Restart And Verify

Start Project Zomboid after the edit. If possible, also run:

```text
Verify_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat
```

Runtime proof still requires a fresh launch and console log confirmation.
