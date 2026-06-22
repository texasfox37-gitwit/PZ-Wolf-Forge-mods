# TDDUP Java Bridge

This repository hosts the **required external Java Bridge** for **TDDUP / Till Death Do Us Part**, a Project Zomboid Build 42 mod.

The Steam Workshop item contains only Workshop-safe Lua and media files. The Workshop subscription by itself is **not enough** for the full TDDUP experience. You must also install this Java Bridge from the official GitHub Releases page for this repository.

## Quick Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid.
3. Download `TDDUP_JavaBridge_GitHubRelease_0.1.36g_FIXED_CleanInstallUninstall.zip` from GitHub Releases.
4. Extract the zip somewhere easy to find, such as your Desktop.
5. Run `INSTALL_TDDUP_JAVA_BRIDGE.bat`.
6. Start Project Zomboid again.
7. Enable the TDDUP Workshop mod in the in-game Mods menu.

If you do not want to use the `.bat` helper, follow [MANUAL_INSTALL.md](MANUAL_INSTALL.md).

## What This Is

The Java Bridge lets TDDUP load required Java agent hooks when Project Zomboid starts. Those hooks are outside what Steam Workshop can safely package, so the bridge is distributed here instead.

## What The Installer Changes

The installer copies the bridge jars into your Project Zomboid game folder and patches `ProjectZomboid64.json` so the bridge loads on startup. It may also create backups before changing files.

For the full plain-English list, see [WHAT_THIS_INSTALLER_CHANGES.md](WHAT_THIS_INSTALLER_CHANGES.md).

## 0.1.36g Clean Install/Uninstall Fix

Use the `0.1.36g_FIXED_CleanInstallUninstall` package instead of the earlier `0.1.36` bridge package.

This update fixes the clean uninstall path for conflict testing. It preserves the base Project Zomboid classpath entries `"."` and `"projectzomboid.jar"`, removes TDDUP bridge entries cleanly, deletes the TDDUP jars from the game root on uninstall, and adds a verification helper.

## Uninstall

The package includes an uninstall path. You can run `REMOVE_TDDUP_JAVA_BRIDGE.bat`, or use the legacy alias `REMOVE_TDDUP_JAVA_AGENTS.bat`. You can also follow [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md) if you prefer to remove the changes yourself.

## Trust And Safety

This bridge package does not add telemetry, does not ask for Steam credentials, does not ask for GitHub tokens, does not install a background service, and does not modify save files.

Only download the bridge from the official GitHub Releases page for this repository. See [SECURITY_AND_TRUST.md](SECURITY_AND_TRUST.md) for details.

## Need Help?

Start with [TROUBLESHOOTING.md](TROUBLESHOOTING.md). If you still need help, open an issue using the install help template.
