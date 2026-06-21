# Troubleshooting

## TDDUP Says Java Bridge Missing

The Workshop mod may be installed, but the required GitHub Java Bridge is not loading.

Fully close Project Zomboid, install the GitHub bridge package, then start the game again.

## Project Zomboid Was Open During Install

Close Project Zomboid completely and run the installer again. The game reads its launch configuration when it starts.

## Antivirus Warning

Some antivirus tools warn about `.bat` or `.ps1` helper scripts. The scripts in this package copy bridge jars and update Project Zomboid's launch configuration.

If you do not want to run them, use [Manual Install](../MANUAL_INSTALL.md).

## Game Update Reset The Launch File

If a Project Zomboid update overwrote `ProjectZomboid64.json`, close the game and run `INSTALL_TDDUP_JAVA_BRIDGE.bat` again.

## Fully Remove The Bridge

Run `REMOVE_TDDUP_JAVA_AGENTS.bat`, or follow [Manual Uninstall](../MANUAL_UNINSTALL.md).

## Workshop Installed But GitHub Bridge Missing

Install the required GitHub bridge too. The Workshop item does not include the external Java Bridge package.
