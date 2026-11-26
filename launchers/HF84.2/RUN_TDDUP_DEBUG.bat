@echo off
rem Optional debug and memory-audit launch; no JSON edits.
call "%~dp0_TDDUP_Launch_Common.cmd" standalone debug
exit /b %ERRORLEVEL%
