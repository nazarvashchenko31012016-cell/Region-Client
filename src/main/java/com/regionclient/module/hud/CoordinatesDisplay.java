package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class CoordinatesDisplay extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", true, "Enable coordinates display");
    public IntegerSetting posX = new IntegerSetting("X Position", 10, 0, 3840, "X position");
    public IntegerSetting posY = new IntegerSetting("Y Position", 70, 0, 2160, "Y position");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "Display scale");
    public IntegerSetting coordColor = new IntegerSetting("Color", 0xFFFFFF, 0, 0xFFFFFF, "Coordinates text color");
    public BooleanSetting showDirection = new BooleanSetting("Show Direction", true, "Show facing direction");

    public CoordinatesDisplay() {
        super("Coordinates", "HUD", "Display player coordinates");
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
        json.addProperty("color", coordColor.getValue());
        json.addProperty("showDirection", showDirection.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("x")) posX.setValue(json.get("x").getAsInt());
        if (json.has("y")) posY.setValue(json.get("y").getAsInt());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("color")) coordColor.setValue(json.get("color").getAsInt());
        if (json.has("showDirection")) showDirection.setValue(json.get("showDirection").getAsBoolean());
    }
}
