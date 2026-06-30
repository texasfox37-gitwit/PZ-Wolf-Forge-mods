# Uninstall

The bridge package includes `uninstaller.bat`.

The uninstaller removes managed TDDUP Java launch entries and removes the two public TDDUP bridge jars copied by this package. It is designed to leave other mods' Java entries alone.

It does not restore old TDDUP backups automatically. Older backups may already contain TDDUP bridge entries, so restoring the newest backup can re-break normal launch.

## Standard Uninstall

1. Fully close Project Zomboid and Steam.
2. Open the extracted bridge package folder.
3. Run `uninstaller.bat`.
4. Start Project Zomboid once to confirm it opens without the bridge.

## Manual Uninstall

If you do not want to use the `.bat` helper, follow the root repository guide: [Manual Uninstall](../MANUAL_UNINSTALL.md).

## Optional Cleanup

After the launch entries are removed, you may delete the `TDDUP_Bridges` folder only if it is empty.

Leave normal Project Zomboid files alone.

For a true Steam-clean `ProjectZomboid64.json`, use Steam's **Verify integrity of game files** option for Project Zomboid.
