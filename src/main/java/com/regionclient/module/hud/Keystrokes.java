package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class Keystrokes extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", true, "Enable keystrokes display");
    public IntegerSetting posX = new IntegerSetting("X Position", 1000, 0, 3840, "X position");
    public IntegerSetting posY = new IntegerSetting("Y Position", 1000, 0, 2160, "Y position");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "Display scale");
    public BooleanSetting showMouse = new BooleanSetting("Show Mouse", true, "Show mouse buttons");
    public IntegerSetting keyColor = new IntegerSetting("Key Color", 0x7B2CBF, 0, 0xFFFFFF, "Key color");

    public Keystrokes() {
        super("Keystrokes", "HUD", "Display keyboard input");
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
        json.addProperty("showMouse", showMouse.getValue());
        json.addProperty("keyColor", keyColor.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("x")) posX.setValue(json.get("x").getAsInt());
        if (json.has("y")) posY.setValue(json.get("y").getAsInt());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("showMouse")) showMouse.setValue(json.get("showMouse").getAsBoolean());
        if (json.has("keyColor")) keyColor.setValue(json.get("keyColor").getAsInt());
    }
}
