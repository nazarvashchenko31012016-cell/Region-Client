package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class FPSCounter extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", true, "Enable FPS counter");
    public IntegerSetting posX = new IntegerSetting("X Position", 10, 0, 3840, "X position");
    public IntegerSetting posY = new IntegerSetting("Y Position", 30, 0, 2160, "Y position");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "Display scale");
    public IntegerSetting fpsColor = new IntegerSetting("Color", 0x00FF00, 0, 0xFFFFFF, "FPS text color");
    public BooleanSetting colorByPerformance = new BooleanSetting("Color By Performance", true, "Change color based on FPS");

    public FPSCounter() {
        super("FPS Counter", "HUD", "Display frames per second");
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
        json.addProperty("color", fpsColor.getValue());
        json.addProperty("colorByPerformance", colorByPerformance.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("x")) posX.setValue(json.get("x").getAsInt());
        if (json.has("y")) posY.setValue(json.get("y").getAsInt());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("color")) fpsColor.setValue(json.get("color").getAsInt());
        if (json.has("colorByPerformance")) colorByPerformance.setValue(json.get("colorByPerformance").getAsBoolean());
    }
}
