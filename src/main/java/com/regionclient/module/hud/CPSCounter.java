package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class CPSCounter extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", true, "Enable CPS counter");
    public IntegerSetting posX = new IntegerSetting("X Position", 1200, 0, 3840, "X position");
    public IntegerSetting posY = new IntegerSetting("Y Position", 1000, 0, 2160, "Y position");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "Display scale");
    public IntegerSetting cpsColor = new IntegerSetting("Color", 0xFF7B2CBF, 0, 0xFFFFFF, "CPS text color");
    public BooleanSetting showAverage = new BooleanSetting("Show Average", true, "Show average CPS");

    public CPSCounter() {
        super("CPS Counter", "HUD", "Display clicks per second");
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
        json.addProperty("color", cpsColor.getValue());
        json.addProperty("showAverage", showAverage.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("x")) posX.setValue(json.get("x").getAsInt());
        if (json.has("y")) posY.setValue(json.get("y").getAsInt());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("color")) cpsColor.setValue(json.get("color").getAsInt());
        if (json.has("showAverage")) showAverage.setValue(json.get("showAverage").getAsBoolean());
    }
}
