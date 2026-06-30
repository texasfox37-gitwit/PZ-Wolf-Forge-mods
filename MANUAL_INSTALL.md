# Manual Install

v3.6.3 does not have an installer. Installing means extracting the release zip into the Project Zomboid game folder.

## 1. Close The Game

Fully close Project Zomboid and Steam.

## 2. Find The Project Zomboid Folder

The default Steam path is usually:

```text
C:\Program Files (x86)\Steam\steamapps\common\ProjectZomboid
```

The folder should contain:

```text
ProjectZomboid64.json
projectzomboid.jar
jre64
```

## 3. Extract The Zip

Extract:

```text
TDDUP_Public_JavaBridge_v3_6_3_DIRECT_LAUNCH_NO_JSON_EDITS.zip
```

into the Project Zomboid folder.

After extraction, you should have:

```text
ProjectZomboid/Launch_TDDUP_Bridge_Alternate.bat
ProjectZomboid/TDDUP_Bridges/TDDUPJavaCombatBridge.jar
ProjectZomboid/TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar
```

If Windows creates a separate extracted folder inside Project Zomboid, you can run the launcher from that folder too.

## 4. Start TDDUP

Run:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

Normal Steam launch may open Project Zomboid, but it will not load the Java Bridge with this package.

## 5. What Not To Do

Do not manually add the TDDUP jars to `ProjectZomboid64.json` for v3.6.3.

Do not restore old TDDUP backup JSON files unless you inspect them first.
