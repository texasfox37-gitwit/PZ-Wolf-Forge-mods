# What This Package Changes

v3.6.3 has **no installer**.

It does not write to `ProjectZomboid64.json`, does not create backups, and does not restore backups.

## Files In The Release Zip

```text
README.txt
Launch_TDDUP_Bridge_Alternate.bat
TDDUP_Bridges/TDDUPJavaCombatBridge.jar
TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar
```

## What Changes When You Extract The Zip

When you extract the zip into the Project Zomboid game folder, these files are added:

```text
<Project Zomboid>/Launch_TDDUP_Bridge_Alternate.bat
<Project Zomboid>/TDDUP_Bridges/TDDUPJavaCombatBridge.jar
<Project Zomboid>/TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar
```

If Windows extracts the zip into a separate folder inside Project Zomboid, the launcher can also run from that extracted folder.

## What The Launcher Does

`Launch_TDDUP_Bridge_Alternate.bat` starts Project Zomboid with the two public TDDUP bridge jars loaded.

It uses Project Zomboid's bundled Java runtime:

```text
jre64/bin/java.exe
```

The launcher does not install, uninstall, copy, delete, download, or edit files.

## What It Does Not Change

The package does not modify:

```text
ProjectZomboid64.json
Project Zomboid save files
Project Zomboid server save files
Steam account data
Steam login data
GitHub login data
Windows services
browser data
```

## Older Installer Cleanup

If an older TDDUP package changed `ProjectZomboid64.json`, v3.6.3 will not automatically repair that file.

Use Steam's **Verify integrity of game files** option for Project Zomboid, or manually remove old TDDUP entries from `ProjectZomboid64.json`.

Do not restore old `ProjectZomboid64.json.bak_TDDUP...` files unless you inspect them first. They may already contain broken TDDUP launch entries.

## Optional Manual JSON Edits

The package does not edit `ProjectZomboid64.json` for you.

Advanced users may choose to edit `ProjectZomboid64.json` by hand so TDDUP and other Java-agent mods can load through the same normal Steam launch.

That manual path is documented in [MANUAL_INSTALL.md](MANUAL_INSTALL.md) and [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md). Back up the file first.
