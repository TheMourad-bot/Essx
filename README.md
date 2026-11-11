# ESSX

**ESSX** is a Fabric client-side social hub for Minecraft Java Edition.

## Target versions

- Minecraft 26.1.2
- Java 25
- Fabric Loader 0.20.1
- Fabric API 0.155.3+26.1.2
- Fabric Loom 1.19-SNAPSHOT

## Working client features

- Right Shift opens the ESSX screen.
- Sidebar navigation for Home, Friends, Messages, Invites, Gallery, Wardrobe, and Settings.
- Local profile file is created at `config/essx/profile.properties`.
- Five persistent local style presets: Aurora, Midnight, Ember, Ocean, and Emerald.
- Press K to cycle the selected local style.
- Client-only: no server installation is required.
- No Microsoft password, Minecraft session token, or account credential collection.

## Online features

Friends, private messages, party invites, account sync, and shared cosmetics require a secure online service. Those features are not falsely presented as working in this client-only build. They need a separately deployed backend, account system, and privacy/security design before they can be enabled.

## Build

Use Java 25 and the Gradle version configured in the workflow:

```sh
gradle build --no-daemon
```

The mod JAR is output to `build/libs/`.
