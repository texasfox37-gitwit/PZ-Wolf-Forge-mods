# Uninstall

The bridge package includes remove and restore helpers.

## Standard Uninstall

1. Fully close Project Zomboid.
2. Open the extracted bridge package folder.
3. Run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
4. Start Project Zomboid once to confirm it opens without the bridge.

## Restore Latest Backup

If you need to restore the newest ProjectZomboid64 backup created by the patcher, run:

```text
Restore_Latest_TDDUP_Backup_v3_4.bat
```

## Manual Uninstall

If you do not want to use the `.bat` helper, follow the root repository guide: [Manual Uninstall](../MANUAL_UNINSTALL.md).

## Optional Cleanup

After the launch entries are removed, you may delete the `TDDUP_Bridges` folder if it contains only TDDUP bridge jars.

Leave normal Project Zomboid files alone.
