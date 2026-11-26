@echo off
setlocal EnableExtensions DisableDelayedExpansion
set "HOST=%~1"
set "TDDUP_DEBUG=%~2"
if /I not "%HOST%"=="zombiebuddy" set "HOST=standalone"
pushd "%~dp0" 2>nul
if errorlevel 1 goto :bad_directory

set "GAME=%CD%"
set "JAVA_EXE=%GAME%\jre64\bin\java.exe"
set "STANDALONE_JAR=%GAME%\TDDUP_Bridges\TDDUPBridgeStandalone.jar"
set "ZB_JAR="
set "SELECTED_JAR="
set "JAVA_HOST_ARG="
set "PZ_CLASSPATH=.;projectzomboid.jar"
set "FALLBACK_NOTE="

if not exist "%JAVA_EXE%" goto :bad_game
if not exist "%GAME%\projectzomboid.jar" goto :bad_game

rem ZombieBuddy may be installed at game root or in Steam Workshop.
if exist "%GAME%\ZombieBuddy.jar" set "ZB_JAR=%GAME%\ZombieBuddy.jar"
if not defined ZB_JAR if exist "%GAME%\..\..\workshop\content\108600\3619862853\mods\ZombieBuddy\libs\ZombieBuddy.jar" set "ZB_JAR=%GAME%\..\..\workshop\content\108600\3619862853\mods\ZombieBuddy\libs\ZombieBuddy.jar"

if /I "%HOST%"=="zombiebuddy" goto :try_zb
:try_standalone
set "HOST=standalone"
if not exist "%STANDALONE_JAR%" goto :no_standalone
set "SELECTED_JAR=%STANDALONE_JAR%"
goto :launch

:try_zb
if not defined ZB_JAR goto :no_zb
set "SELECTED_JAR=%ZB_JAR%"
goto :launch

:launch
rem Avoid double-injecting Java agents inherited from environment variables.
rem ProjectZomboid64.json is deliberately not read or modified.
if defined _JAVA_OPTIONS echo NOTE: Ignoring inherited _JAVA_OPTIONS for this direct-launch session.
if defined JAVA_TOOL_OPTIONS echo NOTE: Ignoring inherited JAVA_TOOL_OPTIONS for this direct-launch session.
if defined JDK_JAVA_OPTIONS echo NOTE: Ignoring inherited JDK_JAVA_OPTIONS for this direct-launch session.
set "_JAVA_OPTIONS="
set "JAVA_TOOL_OPTIONS="
set "JDK_JAVA_OPTIONS="
set "SteamAppId=108600"
set "SteamGameId=108600"

set "PZ_CLASSPATH=%PZ_CLASSPATH%;%SELECTED_JAR%"
set "JAVA_HOST_ARG=-javaagent:%SELECTED_JAR%"
cls
echo ======================================================
echo  TDDUP HF84.2 - Project Zomboid 42.22.2 direct launch
echo ======================================================
echo  Host: %HOST%
echo  No ProjectZomboid64.json modifications.
echo  One Java agent selected for this launch.
if defined ZB_JAR echo  ZombieBuddy found, but only used in ZB mode.
if defined FALLBACK_NOTE echo  %FALLBACK_NOTE%
if /I "%HOST%"=="zombiebuddy" echo  WARNING: ZombieBuddy 2.3.4 may not discover mods in 42.22.2.
echo.
echo  Ensure you enabled the matching TDDUP bridge mod in-game.
echo  Standalone: TDDUP Unified (no extra bridge mod required).
echo  ZombieBuddy: enable ZombieBuddy + TDDUPZBFullBridge.
echo.

if /I "%TDDUP_DEBUG%"=="debug" goto :debug_launch
"%JAVA_EXE%" ^
 -Djava.awt.headless=true ^
 --enable-native-access=ALL-UNNAMED ^
 --add-exports=java.base/jdk.internal.misc=ALL-UNNAMED ^
 -Dzomboid.steam=1 ^
 -Dzomboid.znetlog=1 ^
 -Dtddup.bridge.requestedHost=%HOST% ^
 -XX:+UseZGC ^
 -XX:-CreateCoredumpOnCrash ^
 -XX:-OmitStackTraceInFastThrow ^
 -Xmx4096m ^
 "-Djava.library.path=win64/;." ^
 "-cp" "%PZ_CLASSPATH%" ^
 "%JAVA_HOST_ARG%" ^
 zombie.gameStates.MainScreenState
set "RC=%ERRORLEVEL%"
goto :exit_game

:debug_launch
echo DEBUG mode: GC logs at TDDUP_GC.log; detailed logs in Zomboid\console.txt.
"%JAVA_EXE%" ^
 -Djava.awt.headless=true ^
 --enable-native-access=ALL-UNNAMED ^
 --add-exports=java.base/jdk.internal.misc=ALL-UNNAMED ^
 -Dzomboid.steam=1 ^
 -Dzomboid.znetlog=1 ^
 -Dtddup.bridge.requestedHost=%HOST% ^
 -Dtddup.memdiag=true ^
 -Dtddup.memdiag.interval.ms=60000 ^
 -XX:+UseZGC ^
 -XX:-CreateCoredumpOnCrash ^
 -XX:-OmitStackTraceInFastThrow ^
 -Xmx4096m ^
 "-Xlog:gc*:file=TDDUP_GC.log:time,uptime,level,tags:filecount=3,filesize=8m" ^
 "-Djava.library.path=win64/;." ^
 "-cp" "%PZ_CLASSPATH%" ^
 "%JAVA_HOST_ARG%" ^
 zombie.gameStates.MainScreenState -debug
set "RC=%ERRORLEVEL%"
goto :exit_game

:no_zb
echo.
set "FALLBACK_NOTE=ZombieBuddy JAR not found: using standalone bridge instead."
echo %FALLBACK_NOTE%
echo If you wanted ZombieBuddy, install it and enable the hosted bridge mod.
goto :try_standalone

:no_standalone
echo ERROR: Missing bridge JAR at:
echo  %STANDALONE_JAR%
echo Extract this ZIP directly into the Project Zomboid game folder.
set "RC=5"
goto :fail

:bad_game
echo ERROR: Put the BAT files in the game folder containing:
echo    projectzomboid.jar
echo    jre64\bin\java.exe
echo Do not put them in Zomboid\mods or inside the Workshop mod folder.
set "RC=2"
goto :fail

:bad_directory
echo ERROR: Unable to open the BAT file folder.
exit /b 3

:exit_game
echo.
echo Java exit code: %RC%
if not "%RC%"=="0" goto :fail
popd
exit /b 0

:fail
echo.
echo If launch fails, send console.txt and the visible errors.
pause
popd
exit /b %RC%
