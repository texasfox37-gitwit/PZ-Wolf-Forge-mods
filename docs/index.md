# TDDUP Public Java Bridge

The TDDUP Public Java Bridge is the **required external bridge package** for TDDUP / Till Death Do Us Part on Project Zomboid Build 42.

The Steam Workshop item contains only Workshop-safe Lua and media files. It does not include the bridge jars or installer scripts. To use the full TDDUP mod, you need both:

- the TDDUP Steam Workshop item
- the required Java Bridge package from GitHub Releases

## Current Package

```text
TDDUP_Public_JavaBridge_v3_6_SIMPLE_TWO_JAR.zip
```

This v3.6 package installs only the two public TDDUP bridge jars:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

It patches `ProjectZomboid64.json` so Project Zomboid loads them on startup, while preserving other mods' existing Java entries and memory settings.

## Why It Is Separate From Steam Workshop

Steam Workshop cannot include the required `.bat`, `.jar`, installer, or nested package files. Because of that, the Java Bridge is released separately through GitHub.

## Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid and Steam.
3. Download the required bridge zip from GitHub Releases.
4. Extract the whole folder into your Project Zomboid main folder.
5. Open the extracted folder.
6. Run `installer.bat`.
7. Start Project Zomboid and confirm it reaches the main menu.
8. Enable TDDUP in the in-game Mods menu.
9. Restart Project Zomboid once more before loading a save.

Manual install steps are available on the [Install](install.md) page.

If Project Zomboid will not launch after installing, do not reinstall the game first. Run `uninstaller.bat` from the extracted bridge folder.

## Uninstall

Run `uninstaller.bat` from the extracted bridge package, or follow the [Uninstall](uninstall.md) page.

## Help

If something does not work, start with [Troubleshooting](troubleshooting.md). For safety details, see [Security](security.md). For Steam Workshop copy, see [Workshop](workshop.md).
