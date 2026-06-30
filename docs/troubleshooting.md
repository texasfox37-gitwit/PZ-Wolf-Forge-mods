# Troubleshooting

## TDDUP Says Java Bridge Missing

The Workshop mod may be installed, but the required GitHub Java Bridge is not loading.

Run:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

Workshop subscription alone is not enough.

## Normal Steam Launch Opens But Bridge Is Missing

Normal Steam launch does not load the Java Bridge with v3.6.3.

Use:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Steam Alternate Launch Opens But Bridge Is Missing

Steam Alternate Launch may also skip the Java Bridge.

Use:

```text
Launch_TDDUP_Bridge_Alternate.bat
```

## Launcher Cannot Find Project Zomboid

Place the launcher directly inside the Project Zomboid game folder, or inside one extracted bridge folder directly inside the Project Zomboid game folder.

The Project Zomboid folder should contain `ProjectZomboid64.json` and `projectzomboid.jar`.

## Launcher Cannot Find TDDUP_Bridges

Make sure the release zip was extracted with the `TDDUP_Bridges` folder still present.

That folder must contain:

```text
TDDUPJavaCombatBridge.jar
TTDUP_NPC_RenderBridge.jar
```

## Older Installer Made Normal Launch Fail

v3.6.3 does not edit `ProjectZomboid64.json`, so it will not automatically repair older installer damage.

Use Steam's **Verify integrity of game files** option for Project Zomboid, or manually remove old TDDUP entries from `ProjectZomboid64.json`.

Do not restore the newest `ProjectZomboid64.json.bak_TDDUP...` backup just because it is newest.

## Antivirus Warning

Some antivirus tools warn about `.bat` files.

In v3.6.3, the `.bat` file starts Project Zomboid with the bridge loaded. It does not install, uninstall, copy, delete, download, or edit files.

No telemetry. No credential collection. No background service. No extra downloads.

## Other Java-Agent Mods

The direct launcher does not read `ProjectZomboid64.json`, so other Java-agent mods that depend on that file may not load with the direct launcher.

Advanced users can manually add the TDDUP entries to `ProjectZomboid64.json` and use normal Steam launch instead. Back up the file first. A bad comma can stop the game from launching.
