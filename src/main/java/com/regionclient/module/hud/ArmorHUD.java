package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class ArmorHUD extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", true, "Enable armor HUD");
    public IntegerSetting posX = new IntegerSetting("X Position", 10, 0, 3840, "X position");
    public IntegerSetting posY = new IntegerSetting("Y Position", 100, 0, 2160, "Y position");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "HUD scale");
    public BooleanSetting showDurability = new BooleanSetting("Show Durability", true, "Show durability percentage");
    public BooleanSetting showIcons = new BooleanSetting("Show Icons", true, "Show armor icons");

    public ArmorHUD() {
        super("Armor HUD", "HUD", "Display armor information");
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
        json.addProperty("x", posX.getValue());
        json.addProperty("y", posY.getValue());
        json.addProperty("scale", scale.getValue());
        json.addProperty("showDurability", showDurability.getValue());
        json.addProperty("showIcons", showIcons.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("x")) posX.setValue(json.get("x").getAsInt());
        if (json.has("y")) posY.setValue(json.get("y").getAsInt());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("showDurability")) showDurability.setValue(json.get("showDurability").getAsBoolean());
        if (json.has("showIcons")) showIcons.setValue(json.get("showIcons").getAsBoolean());
    }
}
