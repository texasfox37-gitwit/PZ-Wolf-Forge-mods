# TDDUP Java Bridge

TDDUP / Till Death Do Us Part requires an external Java Bridge package.

Steam Workshop subscription alone is not enough. The Workshop item contains the Workshop-safe Lua and media files only. The Java Bridge must be downloaded from GitHub Releases.

## Current Release

```text
TDDUP_Public_JavaBridge_v3_6_3_DIRECT_LAUNCH_NO_JSON_EDITS.zip
```

v3.6.3 has no installer and no uninstaller. It does not edit `ProjectZomboid64.json`.

## What It Is

The package contains:

```text
README.txt
Launch_TDDUP_Bridge_Alternate.bat
TDDUP_Bridges/TDDUPJavaCombatBridge.jar
TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar
```

The launcher starts Project Zomboid with the two public TDDUP Java bridge jars loaded.

## Install

1. Close Project Zomboid and Steam.
2. Download the bridge zip from GitHub Releases.
3. Extract the zip into the Project Zomboid game folder.
4. Start TDDUP with `Launch_TDDUP_Bridge_Alternate.bat`.

## Uninstall

Delete `Launch_TDDUP_Bridge_Alternate.bat` and delete `TDDUP_Bridges` only if it contains only the two public TDDUP jars.

If an older installer changed `ProjectZomboid64.json`, use Steam's **Verify integrity of game files** option or follow the manual cleanup guide.

## Help

- [Install](install.md)
- [Uninstall](uninstall.md)
- [Troubleshooting](troubleshooting.md)
- [Security](security.md)
- [Workshop Copy](workshop.md)
