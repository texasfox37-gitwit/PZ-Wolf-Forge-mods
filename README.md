# TDDUP Public Java Bridge

This repository hosts the **required external Java Bridge package** for **TDDUP / Till Death Do Us Part**, a Project Zomboid Build 42 mod.

The Steam Workshop item contains only Workshop-safe Lua and media files. The Workshop subscription by itself is **not enough**. You must also install this Java Bridge package from the official GitHub Releases page.

## Current Release

Download:

```text
TDDUP_Public_JavaBridge_v3_6_1_WITH_ALT_LAUNCHER.zip
```

SHA256:

```text
90A80BE938D42511A8222E5C1B65DCF437B65B939303AE2A88146EC233ADDDA9
```

## What Is Included

The public bridge package is intentionally simple:

```text
README.txt
installer.bat
uninstaller.bat
Launch_TDDUP_Bridge_Alternate.bat
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

It does **not** include FirearmAuthority, private body bridge jars, DirectFire test jars, telemetry, auto-downloaders, or credential prompts.

## Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid and Steam.
3. Download `TDDUP_Public_JavaBridge_v3_6_1_WITH_ALT_LAUNCHER.zip` from GitHub Releases.
4. Extract the whole folder into your Project Zomboid main folder.
5. Open the extracted folder.
6. Run `installer.bat`.
7. Start Project Zomboid and confirm it reaches the main menu.
8. Enable the TDDUP Workshop mod in the in-game Mods menu.
9. Restart Project Zomboid once more before loading a save.

## Uninstall

1. Fully close Project Zomboid and Steam.
2. Open the extracted bridge folder.
3. Run `uninstaller.bat`.

The uninstaller restores the backup made by `installer.bat` when possible, then removes the public TDDUP bridge jars copied by this package.

## Optional Alternate Launcher

Use `Launch_TDDUP_Bridge_Alternate.bat` only if normal Project Zomboid launch fails after installing, but Steam's Alternate Launch opens the game without the Java Bridge.

This launcher does not install, copy, delete, or edit files. It starts Project Zomboid through the bundled `jre64` Java runtime and loads the two public TDDUP bridge jars directly.

## What The Installer Changes

The installer copies the two public TDDUP bridge jars into `TDDUP_Bridges` inside your Project Zomboid folder and updates `ProjectZomboid64.json` so Project Zomboid loads them on startup.

It preserves other mods' existing non-TDDUP jar and `-javaagent:` entries, preserves memory settings such as `-Xmx`, and removes old FirearmAuthority/private/dev TDDUP bridge entries from earlier test packages.

For the full plain-English list, see [WHAT_THIS_INSTALLER_CHANGES.md](WHAT_THIS_INSTALLER_CHANGES.md).

## Trust And Safety

No telemetry. No credential collection. No background service. No save-file edits. No auto-downloads.

Only download the bridge from the official GitHub Releases page for this repository. See [SECURITY_AND_TRUST.md](SECURITY_AND_TRUST.md) for details.

## Need Help?

Start with [TROUBLESHOOTING.md](TROUBLESHOOTING.md). If you still need help, open an issue using the install help template.
