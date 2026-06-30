# Troubleshooting

## Steam Workshop Mod Loads But TDDUP Says Java Bridge Missing

The Workshop mod may be installed, but the required GitHub Java Bridge is not loading.

Use the v3.6.2 direct launcher:

1. Fully close Project Zomboid and Steam.
2. Download `TDDUP_Public_JavaBridge_v3_6_2_DIRECT_LAUNCH_ONLY.zip` from the official GitHub Releases page.
3. Extract the whole folder into your Project Zomboid main folder.
4. Open the extracted folder.
5. Run `installer.bat`.
6. Start TDDUP with `Launch_TDDUP_Bridge_Alternate.bat`.

Workshop subscription alone is not enough.

## Normal Steam Launch Opens But TDDUP Says Bridge Missing

Normal Steam launch does not load the Java Bridge with v3.6.2.

Use:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Steam Alternate Launch Opens But TDDUP Says Bridge Missing

Steam Alternate Launch may bypass the Java Bridge too.

Use:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Project Zomboid Will Not Launch After Older v3.6 Or v3.6.1 Installer

v3.6.2 is designed to repair this by removing managed TDDUP Java launch entries from `ProjectZomboid64.json`.

Try this:

1. Fully close Project Zomboid and Steam.
2. Download and extract v3.6.2 into your Project Zomboid main folder.
3. Open the extracted folder.
4. Run `installer.bat`.
5. Start TDDUP with `Launch_TDDUP_Bridge_Alternate.bat`.

If it still fails, report:

```text
console.txt
ProjectZomboid64.json
any hs_err_pid*.log file in the Project Zomboid folder
the exact text or screenshot from the black launcher window
```

## Old Backup Restore Made Normal Launch Fail Again

Older packages could restore the newest `ProjectZomboid64.json.bak_TDDUP...` file.

That is not always safe. A backup may already contain TDDUP bridge entries, so restoring it can put the broken launch entries right back.

Do this instead:

1. Fully close Project Zomboid and Steam.
2. Run the current v3.6.2 `installer.bat` to remove managed TDDUP launch entries from the live `ProjectZomboid64.json`.
3. Start TDDUP with `Launch_TDDUP_Bridge_Alternate.bat`.

If you want a true Steam-clean launcher file, use Steam's **Verify integrity of game files** option for Project Zomboid. Do not manually restore a TDDUP backup unless you have opened it and confirmed it has no `TDDUP_Bridges` or `-javaagent:TDDUP` entries.

## Antivirus Warns About Scripts

The package includes `.bat` scripts. Some antivirus tools warn about scripts because scripts can change local files.

In this package:

- `installer.bat` copies two TDDUP bridge jars and removes managed TDDUP Java launch entries from `ProjectZomboid64.json`.
- `Launch_TDDUP_Bridge_Alternate.bat` starts Project Zomboid with the bridge loaded and does not edit files.
- `uninstaller.bat` removes the public bridge jars and managed TDDUP launch entries.

No telemetry. No credential collection. No background service. No extra downloads.

## Another Java Mod Also Changes ProjectZomboid64.json

v3.6.2 preserves unrelated non-TDDUP `classpath` and `-javaagent:` entries.

It does not auto-load every `.jar` it finds, because some jars are libraries, not Java agents, and blindly loading them can cause crashes.

If users report CTDs with multiple Java mods, ask for:

```text
ProjectZomboid64.json
console.txt
```

## Fully Remove The Bridge

Run:

```text
uninstaller.bat
```

from the extracted bridge folder.

## Workshop Installed But GitHub Bridge Missing

Install the required GitHub bridge too. The TDDUP Workshop item intentionally does not include the external Java Bridge package.
