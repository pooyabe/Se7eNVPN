# Project overview
This is a fork of 2dust/v2rayNG android vpn application.
The application name changed to Se7enVPN.
The main screen activity has simplyfied, almost every element hided, and just remaind a button in the center for connect/disconnect - a top logo, a connection status string and a footer text.
We injected a default VMESS string server config, and made it seleted as the default config for connecting and not the end user can not add or modify server address configs.
This application, has a subscription option.(in default, now the user can not access it). a subscription, is a URL that application make a request to it, and gets updated server configs from that url. so the subscription actually is a upstream server for fetching and updating VPN server addresses based on Xray or V2ray.

# This JOB
Current job is, inject default subscription address, instead of default VMESS config.
So, set the default subscription address on this:
https://d1.sfng.ir:2096/api/v1/dj390mdisksak3d/5569510a-59e6-49c4-b045-994edf3c3094
then, put a Dropdown select under the connect button in the main screen, so every time the application loads, a toast shows: updating. at this time, use the update-subscription-group option from the main application to update the servers list. after updateing, put the received servers in the drop down select box, so user can select a server and connects to it.

# Rules
- First of all think about and create plans, tasks and subtasks before doing anything. write them in the CLAUDE.md file in the ToDo section.
- Store the suumary of what happened and what you did and changes and udpates in JOBS-DONE sections in CLAUDE.md file.

# ToDo

# JOBS-DONE
