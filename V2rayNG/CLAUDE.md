# Project overview
This is a fork of 2dust/v2rayNG android vpn application.

# This JOB
inject a default VMESS URL server addrerss to application, so when app running, it shows in the servers list. VMESS url string example: vmess://eyJ2IjoiMiIsInBzIjoi8J+HqfCfh6ogSC1NRSIsImFkZCI6ImgxLm9wZW5jbGkueHl6IiwicG9ydCI6IjIwODciLCJpZCI6IjgyZTg2MTIxLWE5N2MtNDY1NS1hZTI3LTlhMWIzN2U1Y2Y5ZSIsImFpZCI6IjAiLCJuZXQiOiJ0Y3AiLCJ0eXBlIjoibm9uZSIsImhvc3QiOiIiLCJwYXRoIjoiIiwidGxzIjoiIn0=

# Rules
- First of all create plans, tasks and subtasks before doing anything. write them in the CLAUDE.md file in the Tasks section.
- After doing any step, check that step and move it in to DONE-Tasks section in CLAUDE.md file.
- Store All jobs done and files edited in JOBS-DONE and Edited-Files sections in CLAUDE.md file.

# Tasks

## Plan: Inject Default VMESS Server Address ✅ COMPLETED

### Analysis
The app uses MMKV storage for servers and subscriptions. Servers are stored as ProfileItem objects, grouped by subscription ID. The default subscription ID is `__default_subscription__`. On first run, the app initializes settings and creates a default subscription. I need to inject a default VMESS server into this default subscription.

### Steps Completed:
1. ✅ **Parse the VMESS URL** - Used existing VmessFmt.parse() to convert the URL string to a ProfileItem
2. ✅ **Add during initialization** - Injected the server in `SettingsManager.initApp()` after migrations
3. ✅ **Check if server already exists** - Only adds if no servers exist in the default subscription (first run) using a persistence flag

### Key Files Modified:
- `SettingsManager.kt` - Added `injectDefaultVmessServer()` function and called it from `initApp()`

### VMESS URL Injected:
`vmess://eyJ2IjoiMiIsInBzIjoi8J+HqfCfh6ogSC1NRSIsImFkZCI6ImgxLm9wZW5jbGkueHl6IiwicG9ydCI6IjIwODciLCJpZCI6IjgyZTg2MTIxLWE5N2MtNDY1NS1hZTI3LTlhMWIzN2U1Y2Y5ZSIsImFpZCI6IjAiLCJuZXQiOiJ0Y3AiLCJ0eXBlIjoibm9uZSIsImhvc3QiOiIiLCJwYXRoIjoiIiwidGxzIjoiIn0=`

This decodes to:
- v: 2
- ps: (remarks) - some UTF-8 text
- add: h1.opencli.xyz
- port: 2087
- id: 82e86121-a97c-4655-ae27-9a1b37e5cf9e
- aid: 0
- net: tcp
- type: none
- host: (empty)
- path: (empty)
- tls: (empty)

### Implementation approach:
Added a function `injectDefaultVmessServer()` in SettingsManager that:
1. Checks a persistence flag (`default_vmess_injected`) to avoid re-injection
2. Checks if the default subscription already has servers
3. Parses the VMESS URL using VmessFmt.parse()
4. Sets subscription ID, generates description, saves to MMKV
5. Adds to default subscription's server list
6. Sets as selected server if none selected
7. Marks injection as complete

# Dont-Tasks

# JOBS-DONE
- Added `injectDefaultVmessServer()` function in SettingsManager.kt
- Called from `initApp()` after migrations
- Build compiles successfully

# Edited-Files
- `/home/pooya/Lab/AndroidProjects/Se7enVPN/V2rayNG/app/src/main/java/com/v2ray/ang/handler/SettingsManager.kt` - Added default VMESS server injection logic
