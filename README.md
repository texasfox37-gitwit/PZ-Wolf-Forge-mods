[TDDUP_HF84_2_NoJSON_BAT_Launcher.zip](https://github.com/user-attachments/files/35474731/TDDUP_HF84_2_NoJSON_BAT_Launcher.zip)
# TDDUP Public Java Bridge

This repository hosts the **required external Java Bridge package** for **TDDUP / Till Death Do Us Part**, a Project Zomboid Build 42 mod.

The Java-host setup depends on whether you have **ZombieBuddy**. Current HF91 Workshop-test builds include a `TDDUPZBFullBridge` Java module for ZombieBuddy to discover; players without ZombieBuddy can use the optional standalone bridge/launcher. Older public releases may have different packaging.

## Recommended launch for HF90/HF91 on Project Zomboid 42.22.2

| Setup | Launch method | Required TDDUP component |
|---|---|---|
| **ZombieBuddy installed** | **Normal Steam Play** — no TDDUP BAT needed | Enable the TDDUP main mod and `TDDUPZBFullBridge`; approve its Java module in ZombieBuddy if prompted |
| **Without ZombieBuddy** | Optional `RUN_TDDUP.bat` direct launcher | Install the matching standalone bridge JAR and the TDDUP main mod; do not enable `TDDUPZBFullBridge` |

**Observed:** HF91 test console dated 2026-11-26 verified ZombieBuddy loading `tddup.zbfull.Main`, Java Lua globals injection, new-save spouse creation, the paired intro, and a Follow handoff on Build 42.22.2 using normal Steam launch. This is a successful test, not a guarantee of compatibility on every mod list. It also recorded an unrelated `IsoDoor.ToggleDoorActual` exception.

The launcher source and [optional standalone BAT package](launchers/HF84.2/README.md) remain available for people **without** ZombieBuddy. Do not tell ZombieBuddy subscribers that the BAT launcher is mandatory, and do not load two competing TDDUP host Java agents.

## Build 42.22.2 HF90 — New No-JSON Launcher (release-candidate source)

The **HF84.2 dual-host BAT launcher** for the HF90 Workshop update is now available as [source scripts and documentation](launchers/HF84.2/README.md). It includes standalone, debug, and explicitly selected ZombieBuddy BATs. The source scripts do **not** include the required compiled standalone Java bridge JAR.

The ZIP has been linked as a GitHub user attachment at the top of this README; it is **not the same as a tagged GitHub Release asset**. Do not download the repository source ZIP and assume it contains the compiled Java bridge. Players using ZombieBuddy do not need this standalone BAT package.

The v3.6.3 instructions below apply to the older published launcher, not to the new HF90 package.

## Current Release

Download:

```text
TDDUP_Public_JavaBridge_v3_6_3_DIRECT_LAUNCH_NO_JSON_EDITS.zip
```

SHA256:

```text
F806D7D9A508BBF426DFCBFF0DB146A85C34D13C74C7351DEF88AFC2E9CF1921
```

## What Is Included

```text
README.txt
Launch_TDDUP_Bridge_Alternate.bat
TDDUP_Bridges/TDDUPJavaCombatBridge.jar
TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar
```

There is no installer and no uninstaller in v3.6.3.

## Important v3.6.3 Change

v3.6.3 does **not** edit `ProjectZomboid64.json`.

Earlier packages tried to install or uninstall by changing the Project Zomboid launch JSON. Some users had crashes after that. This release avoids that risk by using a direct launcher instead.

`Launch_TDDUP_Bridge_Alternate.bat` starts Project Zomboid with the two public TDDUP bridge jars loaded. It does not install, uninstall, copy, delete, download, or edit files.

## Install

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid and Steam.
3. Download `TDDUP_Public_JavaBridge_v3_6_3_DIRECT_LAUNCH_NO_JSON_EDITS.zip` from GitHub Releases.
4. Extract the zip into your Project Zomboid main folder.
5. Start TDDUP with `Launch_TDDUP_Bridge_Alternate.bat`.
6. Enable the TDDUP Workshop mod in the in-game Mods menu.
7. Restart through `Launch_TDDUP_Bridge_Alternate.bat` once more before loading a save.

Normal Steam launch may open Project Zomboid, but it will not load the Java Bridge with this package. Steam Alternate Launch may also open the game without the Java Bridge.

## Uninstall

1. Fully close Project Zomboid and Steam.
2. Delete `Launch_TDDUP_Bridge_Alternate.bat`.
3. Delete `TDDUP_Bridges` only if it contains only the two public TDDUP jars.

If an older TDDUP package changed `ProjectZomboid64.json`, v3.6.3 will not automatically repair that file. Use Steam's **Verify integrity of game files** option for a Steam-clean launcher file, or follow [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md) to remove old TDDUP JSON entries by hand.

Do not restore the newest `ProjectZomboid64.json.bak_TDDUP...` file just because it is newest. Older backups may already contain broken TDDUP entries.

## Advanced Manual JSON Option

The default v3.6.3 package does not edit or read `ProjectZomboid64.json`.

Advanced users who need TDDUP and another Java-agent mod to load through the same normal Steam launch can manually add the TDDUP jar lines to `ProjectZomboid64.json`.

This is optional and riskier. Back up `ProjectZomboid64.json` first. A bad comma or broken JSON format can stop Project Zomboid from launching.

See [MANUAL_INSTALL.md](MANUAL_INSTALL.md) and [MANUAL_UNINSTALL.md](MANUAL_UNINSTALL.md).

## Trust And Safety

No telemetry. No credential collection. No background service. No save-file edits. No auto-downloads. No FirearmAuthority, private body bridge, or DirectFire test jars.

Only download the bridge from the official GitHub Releases page for this repository. See [SECURITY_AND_TRUST.md](SECURITY_AND_TRUST.md) for details.

## Need Help?

Start with [TROUBLESHOOTING.md](TROUBLESHOOTING.md). If you still need help, open an issue using the install help template.
