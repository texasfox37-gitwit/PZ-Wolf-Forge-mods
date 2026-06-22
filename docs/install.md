# Install

The Java Bridge is required. Steam Workshop subscription alone is not enough.

## Standard Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid.
3. Download `TDDUP_JavaBridge_GitHubRelease_0.1.36g_FIXED_CleanInstallUninstall.zip` from GitHub Releases.
4. Extract the zip.
5. Run `INSTALL_TDDUP_JAVA_BRIDGE.bat`.
6. Start Project Zomboid again.
7. Enable TDDUP in the in-game Mods menu.

## What The Installer Does

The installer copies the bridge jars into your Project Zomboid game folder and updates `ProjectZomboid64.json` so Project Zomboid loads them on startup.

It may create backups before changing files.

The `0.1.36g` package also preserves `"."` and `"projectzomboid.jar"` in the classpath and includes `VERIFY_TDDUP_JAVA_BRIDGE.bat`.

## Manual Install

If you do not want to use the `.bat` helper, follow the root repository guide: [Manual Install](../MANUAL_INSTALL.md).
