# TDDUP Java Bridge

The TDDUP Java Bridge is the **required external bridge package** for TDDUP / Till Death Do Us Part on Project Zomboid Build 42.

The Steam Workshop item contains only Workshop-safe Lua and media files. It does not include the bridge jars or installer scripts. To use the full TDDUP mod, you need both:

- the TDDUP Steam Workshop item
- the required Java Bridge from GitHub Releases

## Why It Is Separate From Steam Workshop

Steam Workshop cannot include the required `.bat`, `.ps1`, `.jar`, installer, or nested package files. Because of that, the Java Bridge is released separately through GitHub.

## Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid.
3. Download the required bridge zip from GitHub Releases.
4. Extract the zip.
5. Run `INSTALL_TDDUP_JAVA_BRIDGE.bat`.
6. Start Project Zomboid again.

Manual install steps are available on the [Install](install.md) page.

## Uninstall

Run `REMOVE_TDDUP_JAVA_BRIDGE.bat` from the extracted bridge package, or follow the [Uninstall](uninstall.md) page.

## Help

If something does not work, start with [Troubleshooting](troubleshooting.md). For safety details, see [Security](security.md). For Steam Workshop copy, see [Workshop](workshop.md).
