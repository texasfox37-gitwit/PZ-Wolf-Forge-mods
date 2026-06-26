# What This Installer Changes

The TDDUP Java Bridge is required because TDDUP needs Java bridge jars to load when Project Zomboid starts. Steam Workshop cannot include those jars or installer scripts, so they are shipped through GitHub Releases.

## Folder Created Or Updated

The v3.4 patcher copies the bridge jars into:

```text
<Project Zomboid>\TDDUP_Bridges
```

## Files Copied To That Folder

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
TDDUPFirearmAuthorityBridge.jar
TDDUPPrivateBodyBridge.jar
```

The FirearmAuthority jar included in this package is:

```text
0.2.5-v3.4-multi-env-reinject
```

## File Patched

The installer patches:

```text
ProjectZomboid64.json
```

It preserves these base classpath entries:

```json
"."
"projectzomboid.jar"
```

It then adds the bridge folder entries to `classpath`:

```json
"TDDUP_Bridges/TDDUPJavaCombatBridge.jar"
"TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar"
"TDDUP_Bridges/TDDUPFirearmAuthorityBridge.jar"
"TDDUP_Bridges/TDDUPPrivateBodyBridge.jar"
```

It also adds matching `-javaagent:` entries to `vmArgs`.

## Backups

The patcher creates a backup before every install, remove, or restore action.

Backups use names similar to:

```text
ProjectZomboid64.json.bak_TDDUPBridgesV31_YYYYMMDD_HHMMSS
```

## Verify, Remove, And Restore Helpers

```text
Verify_TDDUP_Bridges_ProjectZomboid64_v3_4.bat
Remove_TDDUP_Bridges_ProjectZomboid64_v3_4.bat
Restore_Latest_TDDUP_Backup_v3_4.bat
```

The verify helper confirms that the expected classpath entries, javaagent entries, and bridge jars are present. Runtime proof still requires a fresh Project Zomboid launch and console log confirmation.

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
