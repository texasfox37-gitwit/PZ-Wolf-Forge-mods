# Uninstall

The bridge package includes remove and restore helpers.

The remove helper removes only the managed TDDUP bridge entries and jars. It is designed to leave other mods' Java entries alone.

## Standard Uninstall

1. Fully close Project Zomboid.
2. Open the extracted bridge package folder.
3. Run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_5_CompatMerge.bat`.
4. Start Project Zomboid once to confirm it opens without the bridge.

## Restore Latest Backup

If you need to restore the newest ProjectZomboid64 backup created by the patcher, run:

```text
Restore_Latest_TDDUP_Compat_Backup_v3_5.bat
```

Use this restore helper if Project Zomboid will not launch after installing the bridge and the remove helper does not fix it.

## Manual Uninstall

If you do not want to use the `.bat` helper, follow the root repository guide: [Manual Uninstall](../MANUAL_UNINSTALL.md).

## Optional Cleanup

After the launch entries are removed, you may delete the `TDDUP_Bridges` folder if it contains only TDDUP bridge jars.

Leave normal Project Zomboid files alone.
