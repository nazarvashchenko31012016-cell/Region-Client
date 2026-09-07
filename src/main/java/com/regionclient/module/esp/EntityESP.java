package com.regionclient.module.esp;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class EntityESP extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable entity ESP");
    public BooleanSetting showAnimals = new BooleanSetting("Animals", true, "Show animals");
    public BooleanSetting showMonsters = new BooleanSetting("Monsters", true, "Show monsters");
    public IntegerSetting animalColor = new IntegerSetting("Animal Color", 0x00FF00, 0, 0xFFFFFF, "Animal ESP color");
    public IntegerSetting monsterColor = new IntegerSetting("Monster Color", 0xFF0000, 0, 0xFFFFFF, "Monster ESP color");
    public FloatSetting maxDistance = new FloatSetting("Max Distance", 100.0f, 10.0f, 500.0f, "Maximum render distance");

    public EntityESP() {
        super("Entity ESP", "Render", "ESP for all entities");
    }

    @Override
    public void onTick() {}

    @Override
    public void onRender() {}

    @Override
    public void onKeyPress(int keyCode) {}

    @Override
    public void onEnable() {}

    @Override
    public void onDisable() {}

    @Override
    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("animals", showAnimals.getValue());
        json.addProperty("monsters", showMonsters.getValue());
        json.addProperty("animalColor", animalColor.getValue());
        json.addProperty("monsterColor", monsterColor.getValue());
        json.addProperty("maxDistance", maxDistance.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("animals")) showAnimals.setValue(json.get("animals").getAsBoolean());
        if (json.has("monsters")) showMonsters.setValue(json.get("monsters").getAsBoolean());
        if (json.has("animalColor")) animalColor.setValue(json.get("animalColor").getAsInt());
        if (json.has("monsterColor")) monsterColor.setValue(json.get("monsterColor").getAsInt());
        if (json.has("maxDistance")) maxDistance.setValue(json.get("maxDistance").getAsFloat());
    }
}
