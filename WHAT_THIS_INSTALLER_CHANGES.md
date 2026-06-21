# What This Installer Changes

The TDDUP Java Bridge is required because TDDUP needs Java bridge jars to load when Project Zomboid starts. Steam Workshop cannot include those jars or installer scripts, so they are shipped through GitHub Releases.

## Files Copied To The Project Zomboid Root Folder

The installer copies these files into your Project Zomboid game root folder:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

The installer may also copy Java compatibility DLLs from your existing Project Zomboid `jre64` folder into the game root when needed. These files come from your installed Project Zomboid folder; they are not downloaded.

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

It also ensures the combat bridge jar is present in the launch classpath.

## Backups

The installer may create timestamped backups before modifying files, especially before changing `ProjectZomboid64.json`.

Keep these backups until you have confirmed that Project Zomboid starts correctly.

## Cleanup It May Perform

The installer may remove older duplicate TDDUP, WolfBond, WolfCompanion, or NPC render bridge launch entries from `ProjectZomboid64.json`.

The current installer package may also scan known TDDUP/Wolf companion mod folders for obsolete loose `FBORenderCell.class` cleanup artifacts and remove only those old matching files.

## Uninstall Path

The package includes uninstall scripts:

```text
REMOVE_TDDUP_JAVA_AGENTS.bat
remove_tddup_java_agents.ps1
```

These remove the TDDUP/Wolf/NPC bridge launch entries from `ProjectZomboid64.json`. You can also follow [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md).

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
