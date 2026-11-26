# Suggested GitHub pre-release: TDDUP HF84.2 No-JSON BAT Launcher (B42.22.2)

**Tag:** `tdd-up-nojson-hf84.2-b42.22.2-rc1`

**Release asset to attach:** `TDDUP_HF84_2_NoJSON_BAT_Launcher.zip`

This optional direct-launch package avoids editing game launcher JSON or modifying compiled JARs. It includes the prepared HF84.1 native P4 household-collision standalone agent and Windows BAT launchers. Compatible with the TDDUP HF90 Steam Workshop update.

**Default:** `RUN_TDDUP.bat` — standalone Java host.

**Optional:** `RUN_TDDUP_ZOMBIEBUDDY.bat` — requests ZombieBuddy; checks for its JAR and falls back to standalone when absent. ZombieBuddy discovery is not a guarantee that its Java plugin works on B42.22.2.

**Install:** Extract into the Project Zomboid game folder beside `projectzomboid.jar`, enable HF90 main Workshop mod, and run the preferred BAT. Do not edit `ProjectZomboid64.json`. Do not enable incompatible double Java agent setups.

**Status:** Testing candidate. Single-host game logs have run, but **both launcher pathways have not passed a complete end-user compatibility matrix**; check redistribution rights before public release.

**ZIP SHA-256:** `32721406ea9fd6a7eb708c0b5504e256a060c1b7ca996ed85ef557f21d97ad23`
