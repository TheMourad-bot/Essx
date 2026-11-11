package com.themourad.essx;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class EssxLocalProfile {
    private static final String[] COSMETICS = {
        "Aurora", "Midnight", "Ember", "Ocean", "Emerald"
    };

    private static Path configFile;
    private static String displayName = "Player";
    private static String activeCosmetic = COSMETICS[0];

    private EssxLocalProfile() {
    }

    public static void load(Path configDirectory) {
        try {
            Files.createDirectories(configDirectory);
            configFile = configDirectory.resolve("profile.properties");
            if (Files.exists(configFile)) {
                Properties properties = new Properties();
                try (Reader reader = Files.newBufferedReader(configFile)) {
                    properties.load(reader);
                }
                displayName = properties.getProperty("displayName", "Player");
                activeCosmetic = properties.getProperty("activeCosmetic", COSMETICS[0]);
                if (!isKnownCosmetic(activeCosmetic)) {
                    activeCosmetic = COSMETICS[0];
                }
            } else {
                save();
            }
        } catch (IOException exception) {
            System.err.println("[ESSX] Could not load local profile: " + exception.getMessage());
        }
    }

    public static String getDisplayName() {
        return displayName;
    }

    public static String getActiveCosmetic() {
        return activeCosmetic;
    }

    public static void cycleCosmetic() {
        int current = 0;
        for (int i = 0; i < COSMETICS.length; i++) {
            if (COSMETICS[i].equals(activeCosmetic)) {
                current = i;
                break;
            }
        }
        activeCosmetic = COSMETICS[(current + 1) % COSMETICS.length];
        save();
    }

    private static boolean isKnownCosmetic(String value) {
        for (String cosmetic : COSMETICS) {
            if (cosmetic.equals(value)) {
                return true;
            }
        }
        return false;
    }

    private static void save() {
        if (configFile == null) {
            return;
        }
        Properties properties = new Properties();
        properties.setProperty("displayName", displayName);
        properties.setProperty("activeCosmetic", activeCosmetic);
        try (Writer writer = Files.newBufferedWriter(configFile)) {
            properties.store(writer, "ESSX local profile");
        } catch (IOException exception) {
            System.err.println("[ESSX] Could not save local profile: " + exception.getMessage());
        }
    }
}
