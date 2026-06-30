# Install

The Java Bridge is required. Steam Workshop subscription alone is not enough.

## Standard Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid and Steam.
3. Download `TDDUP_Public_JavaBridge_v3_6_2_DIRECT_LAUNCH_ONLY.zip` from GitHub Releases.
4. Extract the whole zip folder into your Project Zomboid main folder.
5. Open the extracted folder.
6. Run `installer.bat`.
7. Start TDDUP with `Launch_TDDUP_Bridge_Alternate.bat`.
8. Enable TDDUP in the in-game Mods menu.
9. Restart once more through `Launch_TDDUP_Bridge_Alternate.bat` before loading a save.

## What The Installer Does

The installer copies two public bridge jars into `TDDUP_Bridges` inside your Project Zomboid game folder.

It also removes managed TDDUP Java launch entries from `ProjectZomboid64.json`. This is intentional in v3.6.2 because some users can run the bridge through the direct Java route, but normal `ProjectZomboid64.exe` launch hard-crashes when the JSON contains TDDUP `-javaagent` entries.

## How To Launch

Use:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

Normal Steam launch will not load the Java Bridge with v3.6.2.

## Manual Install

If you do not want to use the `.bat` helper, follow the root repository guide: [Manual Install](../MANUAL_INSTALL.md).
