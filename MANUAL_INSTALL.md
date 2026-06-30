# Manual Install

Use this only if you do not want to run `installer.bat`.

The bridge is still required. Manual install only replaces the helper script with steps you do yourself.

## 1. Close Project Zomboid

Fully exit Project Zomboid and Steam before changing files.

## 2. Find Your Project Zomboid Game Folder

You are looking for the folder that contains:

```text
ProjectZomboid64.json
projectzomboid.jar
ProjectZomboid64.exe
```

## 3. Create The Bridge Folder

Inside the Project Zomboid game folder, create:

```text
TDDUP_Bridges
```

## 4. Copy The Two Public Bridge Jars

From the extracted GitHub Release package, copy these files into `TDDUP_Bridges`:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

Do not copy FirearmAuthority, private body bridge, DirectFire, or old test jars for the public TDDUP release.

## 5. Repair ProjectZomboid64.json

Open `ProjectZomboid64.json` in a plain text editor.

Remove TDDUP Java bridge entries from `classpath` and `vmArgs`, including:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
TDDUPFirearmAuthorityBridge.jar
TDDUPPrivateBodyBridge.jar
TDDUPDirectFireAuthorityBridge.jar
```

Leave other mods' non-TDDUP Java entries alone.

Keep normal Project Zomboid base entries:

```json
"."
"projectzomboid.jar"
```

## 6. Launch With The Direct Launcher

Start TDDUP using:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

Normal Steam launch will not load the Java Bridge with v3.6.2.
