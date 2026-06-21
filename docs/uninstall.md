# Uninstall

The bridge package includes an uninstall path.

## Standard Uninstall

1. Fully close Project Zomboid.
2. Open the extracted bridge package folder.
3. Run `REMOVE_TDDUP_JAVA_AGENTS.bat`.
4. Start Project Zomboid once to confirm it opens without the bridge.

## Manual Uninstall

If you do not want to use the `.bat` helper, follow the root repository guide: [Manual Uninstall](../MANUAL_UNINSTALL.md).

## Optional Cleanup

After the launch entries are removed, you may delete these files from the Project Zomboid game root:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

Leave normal Project Zomboid files alone.
