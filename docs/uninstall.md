# Uninstall

v3.6.3 does not include an uninstaller because it does not write to `ProjectZomboid64.json`.

## Remove v3.6.3 Files

1. Fully close Project Zomboid and Steam.
2. Delete `Launch_TDDUP_Bridge_Alternate.bat`.
3. Delete `TDDUP_Bridges` only if it contains only:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

If `TDDUP_Bridges` contains other jars, delete only the two public TDDUP jars.

## Older Installer Cleanup

If an older TDDUP installer changed `ProjectZomboid64.json`, v3.6.3 will not repair that file automatically.

Use Steam's **Verify integrity of game files** option for a Steam-clean launcher file, or follow [Manual Uninstall](../MANUAL_UNINSTALL.md).

Do not restore the newest `ProjectZomboid64.json.bak_TDDUP...` backup just because it is newest. It may already contain broken TDDUP entries.
