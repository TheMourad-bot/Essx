# ESSX

ESSX is a Fabric client-side social and cosmetics mod for Minecraft **26.1.2**.

## Current prototype

- Press **Right Shift** in-game to open the ESSX menu.
- Navigation tabs for Home, Friends, Messages, Invites, Gallery, Wardrobe and Settings.
- Client-only screen; opening it does not pause single-player.

## Build

Requirements:
- JDK 25
- Gradle 9.4+
- Minecraft 26.1.2 / Fabric

Run:

```bash
gradle build
```

The built mod JAR is created in `build/libs/`.

## Planned online features

Friends, presence, direct messages, invites and shared screenshots require an ESSX backend service. This repository currently contains the client prototype only. Microsoft sign-in must use the official Microsoft/Xbox/Minecraft authentication flow; ESSX must never ask users to paste passwords or access tokens.

## Development status

This is an early project scaffold, not a finished replacement for Essential. The UI and online systems will be implemented incrementally and tested against the target Minecraft/Fabric version.
