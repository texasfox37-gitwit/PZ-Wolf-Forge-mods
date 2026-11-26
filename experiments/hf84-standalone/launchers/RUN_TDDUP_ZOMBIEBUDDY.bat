@echo off
rem Optional ZombieBuddy host; detected at runtime. Falls back to standalone if not installed.
rem Needs ZombieBuddy + TDDUPZBFullBridge enabled in the Mods menu.
call "%~dp0_TDDUP_Launch_Common.cmd" zombiebuddy normal
exit /b %ERRORLEVEL%
