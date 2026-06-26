# TDDUP ProjectZomboid64 Bridge Patcher

The TDDUP Java Bridge package is the **required external bridge package** for TDDUP / Till Death Do Us Part on Project Zomboid Build 42.

The Steam Workshop item contains only Workshop-safe Lua and media files. It does not include the bridge jars or installer scripts. To use the full TDDUP mod, you need both:

- the TDDUP Steam Workshop item
- the required Java Bridge package from GitHub Releases

## Current Package

```text
TDDUP_ProjectZomboid64_BridgePatcher_v3_4_FirearmAuthority_MultiEnvReinject.zip
```

This v3.4 package installs all four current bridge jars into a `TDDUP_Bridges` folder and patches `ProjectZomboid64.json` so Project Zomboid loads them on startup.

## Why It Is Separate From Steam Workshop

Steam Workshop cannot include the required `.bat`, `.ps1`, `.jar`, installer, or nested package files. Because of that, the Java Bridge is released separately through GitHub.

## Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid.
3. Download the required bridge zip from GitHub Releases.
4. Extract the whole folder.
5. Run `Install_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
6. Run `Verify_TDDUP_Bridges_ProjectZomboid64_v3_4.bat`.
7. Start Project Zomboid and confirm it reaches the main menu.
8. Enable TDDUP in the in-game Mods menu.
9. Restart Project Zomboid once more before loading a save.

Manual install steps are available on the [Install](install.md) page.

If Project Zomboid will not launch after installing, do not reinstall the game first. Use the remove and restore helpers included in the bridge package.

## Uninstall

Run `Remove_TDDUP_Bridges_ProjectZomboid64_v3_4.bat` from the extracted bridge package, or follow the [Uninstall](uninstall.md) page.

## Help

If something does not work, start with [Troubleshooting](troubleshooting.md). For safety details, see [Security](security.md). For Steam Workshop copy, see [Workshop](workshop.md).
