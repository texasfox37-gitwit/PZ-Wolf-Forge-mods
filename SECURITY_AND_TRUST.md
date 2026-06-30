# Security And Trust

This package is intentionally small and plain.

## What v3.6.3 Does

- Provides `Launch_TDDUP_Bridge_Alternate.bat`.
- Provides `TDDUPJavaCombatBridge.jar`.
- Provides `TTDUP_NPC_RenderBridge.jar`.
- Starts Project Zomboid through Project Zomboid's bundled `jre64\bin\java.exe`.
- Loads the two public TDDUP bridge jars for that launch.

## What v3.6.3 Does Not Do

- Does not include `installer.bat`.
- Does not include `uninstaller.bat`.
- Does not edit `ProjectZomboid64.json`.
- Does not restore old backups.
- Does not install a background service.
- Does not collect telemetry.
- Does not ask for Steam credentials.
- Does not ask for GitHub credentials.
- Does not store passwords, tokens, or personal credentials.
- Does not modify save files.
- Does not download extra files.
- Does not include FirearmAuthority, private body bridge, or DirectFire test jars.

## Downloads

Only download the bridge from the official GitHub Releases page for this repository.

Do not download bridge packages from reupload sites, chat links, or random mirrors.

## Older Backups

Do not restore the newest `ProjectZomboid64.json.bak_TDDUP...` backup just because it is newest. Older backups may already contain the bad TDDUP launch entries.

If you need a Steam-clean launcher file, use Steam's **Verify integrity of game files** option for Project Zomboid.
