# Troubleshooting

## Steam Workshop Mod Loads But TDDUP Says Java Bridge Missing

The Workshop mod may be installed, but the required GitHub Java Bridge is not loading.

Use the v3.6.3 direct launcher:

1. Fully close Project Zomboid and Steam.
2. Download `TDDUP_Public_JavaBridge_v3_6_3_DIRECT_LAUNCH_NO_JSON_EDITS.zip` from the official GitHub Releases page.
3. Extract the zip into your Project Zomboid game folder.
4. Run `Launch_TDDUP_Bridge_Alternate.bat`.

Workshop subscription alone is not enough.

## Normal Steam Launch Opens But TDDUP Says Bridge Missing

Normal Steam launch does not load the Java Bridge with v3.6.3.

Use:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Steam Alternate Launch Opens But TDDUP Says Bridge Missing

Steam Alternate Launch may bypass the Java Bridge too.

Use:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Launcher Cannot Find Project Zomboid

Put `Launch_TDDUP_Bridge_Alternate.bat` either:

- directly inside the Project Zomboid game folder, or
- inside one extracted TDDUP bridge folder that sits directly inside the Project Zomboid game folder.

The Project Zomboid folder should contain `ProjectZomboid64.json` and `projectzomboid.jar`.

## Launcher Cannot Find TDDUP_Bridges

Make sure the zip was extracted with this folder still present:

```text
TDDUP_Bridges
```

That folder must contain:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

## Older Installer Made Normal Launch Fail

v3.6.3 does not edit `ProjectZomboid64.json`, so it will not automatically repair older installer damage.

Use Steam's **Verify integrity of game files** option for Project Zomboid if you want a Steam-clean launcher file.

You can also manually remove old TDDUP entries from `ProjectZomboid64.json`. See [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md).

Do not restore the newest `ProjectZomboid64.json.bak_TDDUP...` file just because it is newest. Older backups may already contain the broken TDDUP entries.

## Antivirus Warns About The Launcher

The package includes one `.bat` file because the bridge must start Project Zomboid with Java agent arguments.

In v3.6.3:

- The `.bat` starts Project Zomboid.
- The `.bat` does not install files.
- The `.bat` does not uninstall files.
- The `.bat` does not edit `ProjectZomboid64.json`.
- The `.bat` does not download anything.

No telemetry. No credential collection. No background service. No save-file edits.

## Another Java Mod Also Changes ProjectZomboid64.json

v3.6.3 does not modify `ProjectZomboid64.json`, so it will not remove or merge other mods' Java entries.

If you use only `Launch_TDDUP_Bridge_Alternate.bat`, other Java-agent mods that depend on `ProjectZomboid64.json` may not load at the same time.

Advanced users can manually add the two public TDDUP bridge entries to `ProjectZomboid64.json` so normal Steam launch can load TDDUP and other Java-agent mods from one file. Back up `ProjectZomboid64.json` first. See [MANUAL_INSTALL.md](MANUAL_INSTALL.md).

If users report CTDs with multiple Java mods, ask for:

```text
ProjectZomboid64.json
console.txt
any hs_err_pid*.log file in the Project Zomboid folder
```

## Fully Remove The Bridge

Delete `Launch_TDDUP_Bridge_Alternate.bat` and delete `TDDUP_Bridges` only if it contains only the two public TDDUP jars.

## Workshop Installed But GitHub Bridge Missing

Install the required GitHub bridge too. The TDDUP Workshop item intentionally does not include the external Java Bridge package.
