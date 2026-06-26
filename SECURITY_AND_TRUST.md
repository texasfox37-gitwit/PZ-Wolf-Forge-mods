# Security And Trust

This page explains what the TDDUP ProjectZomboid64 Bridge Patcher does and does not do.

## What The Installer Does

- Finds your Project Zomboid game folder.
- Copies current TDDUP bridge jars into `TDDUP_Bridges` inside the Project Zomboid game folder.
- Creates a backup before changing `ProjectZomboid64.json`.
- Patches `ProjectZomboid64.json` so Project Zomboid loads the bridge jars at startup.
- Preserves `"."` and `"projectzomboid.jar"` in the classpath.
- Removes older TDDUP/Wolf-era bridge references before adding the current bridge entries.
- Includes verify, remove, and restore helpers.

## Current Bridge Jars

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
TDDUPFirearmAuthorityBridge.jar
TDDUPPrivateBodyBridge.jar
```

## What The Installer Does Not Do

- No telemetry.
- No analytics.
- No auto-downloaders.
- No background services.
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

Some antivirus tools warn about `.bat` or `.ps1` scripts because scripts can change local files. In this package, the scripts copy the bridge jars and update Project Zomboid's launch configuration.

If you are not comfortable running the helper scripts, use [MANUAL_INSTALL.md](MANUAL_INSTALL.md) instead.
