package com.regionclient.manager;

import com.google.gson.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager {
    private static final Path CONFIG_DIR = Paths.get("region-client-configs");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public ConfigManager() {
        try {
            if (!Files.exists(CONFIG_DIR)) {
                Files.createDirectories(CONFIG_DIR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAllConfigs() {
        try {
            if (Files.exists(CONFIG_DIR)) {
                Files.list(CONFIG_DIR)
                        .filter(p -> p.toString().endsWith(".json"))
                        .forEach(this::loadConfig);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadConfig(Path configPath) {
        try {
            String content = Files.readString(configPath);
            JsonObject json = JsonParser.parseString(content).getAsJsonObject();
            // Load config data into modules
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig(String configName, JsonObject data) {
        try {
            Path configPath = CONFIG_DIR.resolve(configName + ".json");
            Files.writeString(configPath, GSON.toJson(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteConfig(String configName) {
        try {
            Path configPath = CONFIG_DIR.resolve(configName + ".json");
            Files.deleteIfExists(configPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
