# Manual Install

Use this if you do not want to run `INSTALL_TDDUP_JAVA_BRIDGE.bat`.

The bridge is still required. Manual install only replaces the helper script with steps you do yourself.

## 1. Close Project Zomboid

Fully exit Project Zomboid before changing files.

## 2. Find Your Project Zomboid Game Folder

You are looking for the folder that contains:

```text
ProjectZomboid64.json
projectzomboid.jar
ProjectZomboid64.exe
jre64
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
ProjectZomboid64.json.backup_before_TDDUP_bridge
```

## 4. Copy The Bridge Jars

From the extracted GitHub Release package, copy these files into the Project Zomboid game folder:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

## 5. Do Not Copy Generic Java DLLs By Default

The `0.1.36g` normal installer does not copy generic Java DLLs by default.

Only use the legacy DLL option if the bridge fails to load on your machine. If you are manually following that legacy path, copy these files from your own Project Zomboid `jre64` folder into the Project Zomboid game root:

```text
jre64\bin\instrument.dll       -> instrument.dll
jre64\bin\java.dll             -> java.dll
jre64\bin\jli.dll              -> jli.dll
jre64\bin\server\jvm.dll       -> jvm.dll
```

Do not download these DLLs from the internet. Use the ones already included with your Project Zomboid install.

## 6. Patch ProjectZomboid64.json

Open `ProjectZomboid64.json` in a plain text editor.

In the `classpath` list, keep the existing entries and make sure this entry exists exactly once:

```json
"."
"projectzomboid.jar"
"TDDUPJavaCombatBridge.jar"
"TTDUP_NPC_RenderBridge.jar"
```

In the `vmArgs` list, keep the existing entries and make sure these entries exist exactly once:

```json
"-Djava.library.path=win64/;.;jre64/bin;jre64/bin/server",
"-javaagent:TDDUPJavaCombatBridge.jar",
"-javaagent:TTDUP_NPC_RenderBridge.jar"
```

Remove older duplicate TDDUP, WolfBond, WolfCompanion, or NPC render bridge `-javaagent` entries if they are present.

## 7. Restart Project Zomboid

Start Project Zomboid after the edit. If TDDUP still says the Java Bridge is missing, see [TROUBLESHOOTING.md](TROUBLESHOOTING.md).
