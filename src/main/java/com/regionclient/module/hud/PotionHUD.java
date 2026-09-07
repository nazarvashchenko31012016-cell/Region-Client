package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class PotionHUD extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", true, "Enable potion HUD");
    public IntegerSetting posX = new IntegerSetting("X Position", 10, 0, 3840, "X position");
    public IntegerSetting posY = new IntegerSetting("Y Position", 200, 0, 2160, "Y position");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "HUD scale");
    public BooleanSetting showDuration = new BooleanSetting("Show Duration", true, "Show effect duration");
    public BooleanSetting showLevel = new BooleanSetting("Show Level", true, "Show effect level");

    public PotionHUD() {
        super("Potion HUD", "HUD", "Display potion effects");
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
        json.addProperty("showDuration", showDuration.getValue());
        json.addProperty("showLevel", showLevel.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("x")) posX.setValue(json.get("x").getAsInt());
        if (json.has("y")) posY.setValue(json.get("y").getAsInt());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("showDuration")) showDuration.setValue(json.get("showDuration").getAsBoolean());
        if (json.has("showLevel")) showLevel.setValue(json.get("showLevel").getAsBoolean());
    }
}
