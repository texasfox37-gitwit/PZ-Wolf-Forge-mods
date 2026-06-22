# What This Installer Changes

The TDDUP Java Bridge is required because TDDUP needs Java bridge jars to load when Project Zomboid starts. Steam Workshop cannot include those jars or installer scripts, so they are shipped through GitHub Releases.

## Files Copied To The Project Zomboid Root Folder

The installer copies these files into your Project Zomboid game root folder:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

The normal `0.1.36g` installer does not copy generic Java DLLs by default. A separate legacy DLL helper is included only for users whose bridge fails to load without those DLLs. Those DLLs come from your installed Project Zomboid folder; they are not downloaded.

## File Patched

The installer patches:

```text
ProjectZomboid64.json
```

It adds the bridge jar entries needed for Project Zomboid to load:

```text
-javaagent:TDDUPJavaCombatBridge.jar
-javaagent:TTDUP_NPC_RenderBridge.jar
```

It also preserves the base Project Zomboid classpath entries and then adds the bridge jars. The classpath should begin like this after install:

```json
".",
"projectzomboid.jar",
"TDDUPJavaCombatBridge.jar",
"TTDUP_NPC_RenderBridge.jar"
```

## Backups

The installer may create timestamped backups before modifying files, especially before changing `ProjectZomboid64.json`.

Keep these backups until you have confirmed that Project Zomboid starts correctly.

## Install Manifest And Verification

The `0.1.36g` package writes a small install manifest:

```text
TDDUPJavaBridge.install-manifest.json
```

It also includes verification helpers:

```text
VERIFY_TDDUP_JAVA_BRIDGE.bat
verify_tddup_java_bridge.ps1
```

## Cleanup It May Perform

The installer may remove older duplicate TDDUP, WolfBond, WolfCompanion, or NPC render bridge launch entries from `ProjectZomboid64.json`.

The current installer package may also scan known TDDUP/Wolf companion mod folders for obsolete loose `FBORenderCell.class` cleanup artifacts and remove only those old matching files.

## Uninstall Path

The package includes uninstall scripts:

```text
REMOVE_TDDUP_JAVA_BRIDGE.bat
REMOVE_TDDUP_JAVA_AGENTS.bat
remove_tddup_java_bridge.ps1
```

These remove the TDDUP/Wolf/NPC bridge launch entries and bridge classpath entries from `ProjectZomboid64.json`, delete the TDDUP bridge jars from the game root, remove the install manifest, and preserve `"."` plus `"projectzomboid.jar"`. You can also follow [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md).

## Files The Installer Does Not Modify

The installer does not modify:

```text
Project Zomboid save files
Project Zomboid server save files
Steam account data
Steam login data
GitHub login data
Windows services
browser data
```
