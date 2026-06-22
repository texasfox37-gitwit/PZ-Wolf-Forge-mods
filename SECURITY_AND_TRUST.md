# Security And Trust

This page explains what the TDDUP Java Bridge installer does and does not do.

## What The Installer Does

- Copies `TDDUPJavaCombatBridge.jar` into the Project Zomboid game root folder.
- Copies `TTDUP_NPC_RenderBridge.jar` into the Project Zomboid game root folder.
- Does not copy generic Java DLLs by default.
- Includes a legacy DLL helper only for users whose bridge fails to load without those DLLs.
- Creates backups before changing `ProjectZomboid64.json`.
- Patches `ProjectZomboid64.json` so Project Zomboid loads the TDDUP bridge jars at startup.
- Removes older duplicate TDDUP/Wolf/NPC bridge launch entries when found.
- Includes uninstall scripts that remove bridge launch entries, bridge classpath entries, TDDUP bridge jars, and the install manifest.

## What The Installer Does Not Do

- No telemetry.
- No analytics.
- No auto-downloaders.
- No background services.
- No generic Java DLL copying by default.
- No Steam credential collection.
- No GitHub token collection.
- No personal credential collection.
- No save-file modification.
- No server-save modification.
- No Steam client modification.
- No hidden remote payload download.

## Download Safety

Only download the bridge from the official GitHub Releases page for this repository.

Do not download bridge installers from random file mirrors, Discord reposts, or reuploaded archives unless the TDDUP maintainers explicitly point you there.

Before release, the published `SHA256SUMS.txt` should match the zip attached to the GitHub Release.

## Antivirus Notes

Some antivirus tools warn about `.bat` or `.ps1` scripts because scripts can change local files. In this package, the scripts are used to copy the bridge jars and update Project Zomboid's launch configuration.

If you are not comfortable running the helper scripts, use [MANUAL_INSTALL.md](MANUAL_INSTALL.md) instead.
