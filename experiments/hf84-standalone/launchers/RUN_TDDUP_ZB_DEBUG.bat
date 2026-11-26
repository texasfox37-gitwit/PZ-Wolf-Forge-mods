@echo off
rem Optional ZombieBuddy DEBUG host.
call "%~dp0_TDDUP_Launch_Common.cmd" zombiebuddy debug
exit /b %ERRORLEVEL%
