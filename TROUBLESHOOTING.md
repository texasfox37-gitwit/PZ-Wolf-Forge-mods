# Troubleshooting

## Steam Workshop Mod Loads But TDDUP Says Java Bridge Missing

This means the Workshop mod is installed, but the required GitHub Java Bridge is not loading.

Try this:

1. Fully close Project Zomboid.
2. Download the bridge zip from the official GitHub Releases page.
3. Extract the zip.
4. Run `INSTALL_TDDUP_JAVA_BRIDGE.bat`.
5. Start Project Zomboid again.

Workshop subscription alone is not enough.

## I Installed The Bridge While Project Zomboid Was Open

Close Project Zomboid completely, then run the installer again.

Project Zomboid reads its launch configuration when it starts. If the game was already open, it may not see the bridge until the next full restart.

## Antivirus Warns About Scripts

The package includes `.bat` and `.ps1` helper scripts. Some antivirus tools warn about scripts because scripts can change local files.

In this package, the scripts copy the bridge jars and patch `ProjectZomboid64.json` so Project Zomboid loads the bridge. They do not collect credentials, install a service, or download extra payloads.

If you do not want to run the helper scripts, follow [MANUAL_INSTALL.md](MANUAL_INSTALL.md).

## A Game Update Overwrote ProjectZomboid64.json

Project Zomboid or Steam updates may replace or reset `ProjectZomboid64.json`.

If TDDUP worked before and now says the bridge is missing:

1. Fully close Project Zomboid.
2. Run `INSTALL_TDDUP_JAVA_BRIDGE.bat` again.
3. Start Project Zomboid again.

## I Want To Fully Remove The Bridge

Run:

```text
REMOVE_TDDUP_JAVA_BRIDGE.bat
```

Or follow [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md).

After removing the launch entries, you may delete these files from the Project Zomboid game root:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

## Uninstall Did Not Fully Clean Up The Bridge

Use the `0.1.36g_FIXED_CleanInstallUninstall` package. It includes a corrected uninstaller that removes the TDDUP javaagent entries, TDDUP classpath entries, bridge jars, and install manifest while preserving `"."` and `"projectzomboid.jar"`.

Run:

```text
REMOVE_TDDUP_JAVA_BRIDGE.bat
```

Then run:

```text
VERIFY_TDDUP_JAVA_BRIDGE.bat
```

## I Installed The Workshop Item But Not The GitHub Bridge

Install the GitHub bridge too. The TDDUP Workshop item intentionally does not include the external Java Bridge package.

Download the required bridge zip from GitHub Releases, close Project Zomboid, and run the installer.
