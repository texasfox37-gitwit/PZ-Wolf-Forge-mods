# Install

v3.6.3 does not have an installer. Installing means extracting the release zip into the Project Zomboid game folder.

## Steps

1. Subscribe to the TDDUP Steam Workshop item.
2. Fully close Project Zomboid and Steam.
3. Download `TDDUP_Public_JavaBridge_v3_6_3_DIRECT_LAUNCH_NO_JSON_EDITS.zip` from GitHub Releases.
4. Extract the zip into your Project Zomboid game folder.
5. Run `Launch_TDDUP_Bridge_Alternate.bat`.
6. Enable TDDUP in the in-game Mods menu.
7. Restart once more with `Launch_TDDUP_Bridge_Alternate.bat` before loading a save.

## Expected Files

After extraction, you should have:

```text
ProjectZomboid/Launch_TDDUP_Bridge_Alternate.bat
ProjectZomboid/TDDUP_Bridges/TDDUPJavaCombatBridge.jar
ProjectZomboid/TDDUP_Bridges/TTDUP_NPC_RenderBridge.jar
```

If Windows creates a separate extracted folder inside Project Zomboid, you can run the launcher from that folder too.

## Important

Normal Steam launch may open Project Zomboid, but it will not load the Java Bridge with this package.

Advanced users may manually add the TDDUP jars to `ProjectZomboid64.json` if they need normal Steam launch to load TDDUP and other Java-agent mods together.

Back up `ProjectZomboid64.json` first. A broken JSON file can stop Project Zomboid from launching.

See [Manual Install](../MANUAL_INSTALL.md).
