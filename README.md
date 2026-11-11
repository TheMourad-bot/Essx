# ESSX

**ESSX** is a Fabric client-side social hub for Minecraft Java Edition.

## Current target

- Minecraft 26.1.2
- Java 25
- Fabric Loader 0.20.1
- Fabric API 0.155.3+26.1.2
- Fabric Loom 1.19-SNAPSHOT

## Current foundation

- Right Shift opens the ESSX menu.
- Sidebar navigation: Home, Friends, Messages, Invites, Gallery, Wardrobe, Settings.
- Dark custom interface.
- Client-only; it does not require installation on a multiplayer server.

## Development roadmap

1. Stable client foundation and polished interface.
2. Local settings and screenshot gallery.
3. Account and friends service.
4. Messaging and party invites.
5. Cosmetics and profile features.

Online features require a separate secure service. This initial build does not collect Microsoft passwords, session tokens, or other account credentials.

## Build

Use Java 25 and Gradle 9.8.2 or newer compatible with the configured Fabric Loom version.

```sh
gradle build
```

The mod JAR is created in `build/libs/`.
