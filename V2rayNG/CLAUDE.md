# Project overview
This is a fork of 2dust/v2rayNG android vpn application.

# This JOB
Simplify the application main page, and just left the connect button and the connection status string (clickable). hide all other things and we don't want them. set some beautyfull style to remain items and make them center. in other word, we want just a simple apllication screen with a connect button and a clickable connection statusstring. that string, is now clickable by deafult and you don't have to add or modify anything for it's functionality. 

# Rules
- First of all create plans, tasks and subtasks before doing anything. write them in the CLAUDE.md file in the Tasks section.
- After doing any step, check that step and move it in to DONE-Tasks section in CLAUDE.md file.
- Store All jobs done and files edited in JOBS-DONE and Edited-Files sections in CLAUDE.md file.

# Tasks
- [x] Analyze current MainScreen and MainBottomBar structure
- [x] Create simplified MainScreen composable (only connect button and clickable status string)
- [x] Create simplified MainBottomBar composable (only connect button and clickable status string)
- [x] Compile and verify the changes work

# DONE-Tasks
- Analyzed current MainScreen and MainBottomBar structure
- Created simplified MainScreen composable with centered connect button and clickable status string
- Created simplified MainBottomBar composable with centered connect button and clickable status string
- Fixed compilation errors (TextAlign import, collectAsStateWithLifecycle delegate, alignment issues)
- Verified successful compilation

# JOBS-DONE
1. Simplified MainScreen.kt - removed Scaffold, top bar, bottom bar, group tabs, horizontal pager, and all other UI elements. Now only shows a centered connect button and a clickable connection status string.
2. Simplified MainBottomBar.kt - removed FAB and old layout. Now only shows centered connect button and clickable connection status string.
3. Both components now use beautiful Material3 styling with centered layout.

# Edited-Files
- app/src/main/java/com/v2ray/ang/ui/main/MainScreen.kt
- app/src/main/java/com/v2ray/ang/ui/main/MainBottomBar.kt

