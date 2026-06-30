# Troubleshooting

## TDDUP Says Java Bridge Missing

The Workshop mod may be installed, but the required GitHub Java Bridge is not loading.

Run `installer.bat`, then start TDDUP with:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Normal Steam Launch Opens But Bridge Is Missing

Normal Steam launch does not load the Java Bridge with v3.6.2.

Use:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Steam Alternate Launch Opens But Bridge Is Missing

Steam Alternate Launch may also skip the Java Bridge.

Use:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Older Installer Made Normal Launch Fail

Run the v3.6.2 `installer.bat`. It removes managed TDDUP Java launch entries from `ProjectZomboid64.json` and copies the two public bridge jars.

Then start TDDUP with:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Old Backup Restore Re-added Bad Entries

Do not restore the newest `ProjectZomboid64.json.bak_TDDUP...` file just because it is newest.

Some backups may already contain TDDUP bridge entries. Restoring one of those backups can put the broken launch entries back.

Use the current v3.6.2 `installer.bat` to remove managed TDDUP entries from the live file. If you need a true Steam-clean `ProjectZomboid64.json`, use Steam's **Verify integrity of game files** option for Project Zomboid.

## Antivirus Warning

Some antivirus tools warn about `.bat` helper scripts. The scripts in this package copy two bridge jars, repair managed TDDUP Java launch entries, or start Project Zomboid with the bridge loaded.

No telemetry. No credential collection. No background service. No extra downloads.

## Another Java Mod Also Changes ProjectZomboid64.json

v3.6.2 preserves non-TDDUP Java entries that are already in `ProjectZomboid64.json`.

Do not auto-load every `.jar` you find. Some jars are libraries, not Java agents, and blindly loading them can cause crashes.

## Fully Remove The Bridge

Run `uninstaller.bat`, or follow [Manual Uninstall](../MANUAL_UNINSTALL.md).

## Workshop Installed But GitHub Bridge Missing

Install the required GitHub bridge too. The Workshop item does not include the external Java Bridge package.
