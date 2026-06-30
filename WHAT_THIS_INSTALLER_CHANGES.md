# What This Installer Changes

The TDDUP Public Java Bridge is required because TDDUP needs Java bridge jars to load when Project Zomboid starts. Steam Workshop cannot include `.bat` or `.jar` files, so the bridge is shipped through GitHub Releases.

## Files Included In The Release Folder

```text
README.txt
installer.bat
uninstaller.bat
Launch_TDDUP_Bridge_Alternate.bat
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

## Folder Created Or Updated

The installer creates or updates:

```text
<Project Zomboid>\TDDUP_Bridges
```

## Files Copied To That Folder

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

## ProjectZomboid64.json Repair

v3.6.2 does **not** add TDDUP bridge entries to `ProjectZomboid64.json`.

Instead, the installer removes managed TDDUP Java launch entries from `ProjectZomboid64.json`, including:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
TDDUPFirearmAuthorityBridge.jar
TDDUPPrivateBodyBridge.jar
TDDUPDirectFireAuthorityBridge.jar
WBJavaCombatBridge.jar
WolfBondJavaCombatBridge.jar
WolfCompanionJavaBridge.jar
```

It preserves unrelated mods' non-TDDUP `classpath` entries and `-javaagent:` entries.

## Backups

If the installer repairs `ProjectZomboid64.json`, it creates a backup first.

Backups use names like:

```text
ProjectZomboid64.json.bak_TDDUPDirectLauncher_YYYYMMDD_HHMMSS
```

The uninstaller does not automatically restore old backups because older backups may contain the launch entries that caused normal launch to fail.

Backups are for inspection and emergency manual recovery only. They are not treated as guaranteed vanilla files.

If you need a true Steam-clean `ProjectZomboid64.json`, use Steam's **Verify integrity of game files** option for Project Zomboid. The bridge package does not ship a fixed vanilla JSON template because Project Zomboid updates can change that file.

## Direct Launcher

`Launch_TDDUP_Bridge_Alternate.bat` starts Project Zomboid with the two public TDDUP bridge jars loaded through Project Zomboid's bundled `jre64` Java runtime.

The direct launcher does not install, copy, delete, or edit files.

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
