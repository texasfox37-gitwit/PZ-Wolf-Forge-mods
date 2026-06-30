# TDDUP Public Java Bridge

The TDDUP Public Java Bridge is the **required external bridge package** for TDDUP / Till Death Do Us Part on Project Zomboid Build 42.

The Steam Workshop item contains only Workshop-safe Lua and media files. It does not include the bridge jars or installer scripts. To use the full TDDUP mod, you need both:

- the TDDUP Steam Workshop item
- the required Java Bridge package from GitHub Releases

## Current Package

```text
TDDUP_Public_JavaBridge_v3_6_2_DIRECT_LAUNCH_ONLY.zip
```

This v3.6.2 package installs only the two public TDDUP bridge jars:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

It uses `Launch_TDDUP_Bridge_Alternate.bat` as the supported bridge launch path. The installer copies the jars and removes old managed TDDUP Java launch entries from `ProjectZomboid64.json`.

## Why It Is Separate From Steam Workshop

Steam Workshop cannot include the required `.bat`, `.jar`, installer, or nested package files. Because of that, the Java Bridge is released separately through GitHub.

## Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid and Steam.
3. Download the required bridge zip from GitHub Releases.
4. Extract the whole folder into your Project Zomboid main folder.
5. Open the extracted folder.
6. Run `installer.bat`.
7. Start TDDUP with `Launch_TDDUP_Bridge_Alternate.bat`.
8. Enable TDDUP in the in-game Mods menu.
9. Restart once more through `Launch_TDDUP_Bridge_Alternate.bat` before loading a save.

Normal Steam launch and Steam Alternate Launch may open the game without loading the Java Bridge.

## Uninstall

Run `uninstaller.bat` from the extracted bridge package, or follow the [Uninstall](uninstall.md) page.

## Help

If something does not work, start with [Troubleshooting](troubleshooting.md). For safety details, see [Security](security.md). For Steam Workshop copy, see [Workshop](workshop.md).
