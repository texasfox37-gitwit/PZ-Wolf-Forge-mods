# Manual Uninstall

v3.6.3 does not include an uninstaller because it does not install into `ProjectZomboid64.json`.

## Remove v3.6.3 Files

1. Fully close Project Zomboid and Steam.
2. Delete `Launch_TDDUP_Bridge_Alternate.bat` if you copied it into the Project Zomboid folder.
3. Delete `TDDUP_Bridges` only if it contains only these two files:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

If `TDDUP_Bridges` contains other jars for other mods or private testing, do not delete the whole folder. Delete only the two public TDDUP jars listed above.

## If An Older Installer Changed ProjectZomboid64.json

v3.6.3 will not repair `ProjectZomboid64.json` automatically.

For a Steam-clean launcher file, use Steam's **Verify integrity of game files** option for Project Zomboid.

If you prefer to edit manually, open `ProjectZomboid64.json` and remove old TDDUP entries from `classpath` and `vmArgs`, including entries that mention:

```text
TDDUP_Bridges
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
TDDUPFirearmAuthorityBridge.jar
TDDUPPrivateBodyBridge.jar
TDDUPDirectFireAuthorityBridge.jar
WBJavaCombatBridge.jar
WolfBondJavaCombatBridge.jar
WolfCompanionJavaBridge.jar
```

Leave non-TDDUP entries alone.

Do not restore the newest `ProjectZomboid64.json.bak_TDDUP...` file just because it is newest. Older backups may already contain the broken TDDUP entries.
