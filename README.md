# TDDUP Public Java Bridge

This repository hosts the **required external Java Bridge package** for **TDDUP / Till Death Do Us Part**, a Project Zomboid Build 42 mod.

The Steam Workshop item contains only Workshop-safe Lua and media files. The Workshop subscription by itself is **not enough**. You must also install this Java Bridge package from the official GitHub Releases page.

## Current Release

Download:

```text
TDDUP_Public_JavaBridge_v3_6_2_DIRECT_LAUNCH_ONLY.zip
```

SHA256:

```text
2DA03387B9768B4ED66A2412762192125DCFD5C4B8E46E29705B482D22EB2EA0
```

## What Is Included

```text
README.txt
installer.bat
uninstaller.bat
Launch_TDDUP_Bridge_Alternate.bat
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

It does **not** include FirearmAuthority, private body bridge jars, DirectFire test jars, telemetry, auto-downloaders, or credential prompts.

## Important v3.6.2 Change

v3.6.2 uses a direct launcher instead of relying on the normal `ProjectZomboid64.exe` launcher path.

Some users could run the proven direct Java command, but normal launch hard-crashed after `ProjectZomboid64.json` was patched with `-javaagent` entries. Because of that, this package no longer adds TDDUP `-javaagent` entries to `ProjectZomboid64.json`.

## Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid and Steam.
3. Download `TDDUP_Public_JavaBridge_v3_6_2_DIRECT_LAUNCH_ONLY.zip` from GitHub Releases.
4. Extract the whole folder into your Project Zomboid main folder.
5. Open the extracted folder.
6. Run `installer.bat`.
7. Start TDDUP with `Launch_TDDUP_Bridge_Alternate.bat`.
8. Enable the TDDUP Workshop mod in the in-game Mods menu.
9. Restart through `Launch_TDDUP_Bridge_Alternate.bat` once more before loading a save.

Normal Steam launch may open Project Zomboid, but it will not load the Java Bridge with this package. Steam Alternate Launch may also open the game without the Java Bridge.

## What The Installer Changes

The installer copies the two public TDDUP bridge jars into `TDDUP_Bridges` inside your Project Zomboid folder.

It also removes managed TDDUP Java launch entries from `ProjectZomboid64.json` so the normal launcher is not left with the entries that caused hard-crashes for some users. It preserves other mods' non-TDDUP jar and `-javaagent:` entries.

Important backup note: do not restore old `ProjectZomboid64.json.bak_TDDUP...` files just because they are newest. Older backups can already contain TDDUP bridge entries. If you need a true Steam-clean launcher file, use Steam's **Verify integrity of game files** option for Project Zomboid.

For the full plain-English list, see [WHAT_THIS_INSTALLER_CHANGES.md](WHAT_THIS_INSTALLER_CHANGES.md).

## Uninstall

1. Fully close Project Zomboid and Steam.
2. Open the extracted bridge folder.
3. Run `uninstaller.bat`.

The uninstaller removes managed TDDUP Java launch entries and removes the two public TDDUP bridge jars copied by this package.

## Trust And Safety

No telemetry. No credential collection. No background service. No save-file edits. No auto-downloads.

Only download the bridge from the official GitHub Releases page for this repository. See [SECURITY_AND_TRUST.md](SECURITY_AND_TRUST.md) for details.

## Need Help?

Start with [TROUBLESHOOTING.md](TROUBLESHOOTING.md). If you still need help, open an issue using the install help template.
