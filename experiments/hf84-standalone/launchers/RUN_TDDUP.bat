@echo off
rem Default recommended B42.22.2 direct launch. Uses TDDUP standalone HF84.1+P4.
call "%~dp0_TDDUP_Launch_Common.cmd" standalone normal
exit /b %ERRORLEVEL%
