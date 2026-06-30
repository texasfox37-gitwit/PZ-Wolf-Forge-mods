# Manual Install

v3.6.3 does not have an installer. The normal install is just extracting the release zip into the Project Zomboid game folder and using the direct launcher.

There is also an optional advanced manual JSON method for users who need TDDUP and another Java-agent mod to load through the same normal Steam launch.

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

## 4. Recommended Start Method

Run:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

Normal Steam launch may open Project Zomboid, but it will not load the Java Bridge with this default v3.6.3 method.

## 5. Optional Advanced JSON Method

Most users should stop at the direct launcher above.

Only use this section if you understand that a broken JSON file can stop Project Zomboid from launching.

This manual method may help users who need TDDUP and another Java-agent mod to load from the same `ProjectZomboid64.json`.

Before editing:

1. Fully close Project Zomboid and Steam.
2. Make a copy of `ProjectZomboid64.json`.
3. Name the copy something clear, such as:

```text
ProjectZomboid64.json.backup_before_TDDUP_manual_edit
```

Open `ProjectZomboid64.json` in a plain text editor.

In the `classpath` list, add these two entries:

```json
"TDDUP_Bridges/TDDUPJavaCombatBridge.jar",
"TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
```

In the `vmArgs` list, add these two entries:

```json
"-javaagent:TDDUP_Bridges/TDDUPJavaCombatBridge.jar",
"-javaagent:TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
```

Do not copy a whole example JSON file over your file. Only add the TDDUP lines to your existing lists.

Commas matter in JSON. Every line in a list needs a comma after it except the last line in that list.

If another mod already has its own jar or `-javaagent` lines, leave those lines alone.

After saving, start Project Zomboid normally through Steam. If the game does not launch, restore your backup copy or use Steam's **Verify integrity of game files** option.

## 6. Manual JSON Example

This is only an example of the two lists. Your real file may have more entries.

```json
"classpath": [
  ".",
  "projectzomboid.jar",
  "TDDUP_Bridges/TDDUPJavaCombatBridge.jar",
  "TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
],
"vmArgs": [
  "-Djava.awt.headless=true",
  "-Xmx3072m",
  "-Dzomboid.steam=1",
  "-Dzomboid.znetlog=1",
  "-Djava.library.path=win64/;.",
  "-XX:-CreateCoredumpOnCrash",
  "-XX:-OmitStackTraceInFastThrow",
  "-javaagent:TDDUP_Bridges/TDDUPJavaCombatBridge.jar",
  "-javaagent:TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
]
```

Do not paste this whole example over your real file. Use it only to see where the TDDUP lines belong.
