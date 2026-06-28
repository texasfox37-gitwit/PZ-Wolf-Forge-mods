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

## File Patched

The installer patches:

```text
ProjectZomboid64.json
```

It preserves existing non-TDDUP `classpath` entries, including:

```json
"."
"projectzomboid.jar"
```

It adds the public bridge entries:

```json
"TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
```

It also preserves existing non-TDDUP `-javaagent:` entries in `vmArgs`, then adds matching public TDDUP `-javaagent:` entries.

## Cleanup

The installer removes stale TDDUP bridge entries from older test packages, including FirearmAuthority, private body bridge, and DirectFire test entries. It does not remove unrelated mods' Java entries.

## Backups

The installer creates a backup before writing changes.

Backups use names like:

```text
ProjectZomboid64.json.bak_TDDUPPublicBridge_YYYYMMDD_HHMMSS
```

The uninstaller restores the latest backup made by `installer.bat` when possible, then removes the two public TDDUP bridge jars copied by this package.

## Optional Alternate Launcher

`Launch_TDDUP_Bridge_Alternate.bat` is a fallback launcher for users whose normal Project Zomboid launch path fails but Steam's Alternate Launch opens without the Java Bridge.

It does not install, copy, delete, or edit files. It starts Project Zomboid with the two public TDDUP bridge jars loaded through Project Zomboid's bundled Java runtime.

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
