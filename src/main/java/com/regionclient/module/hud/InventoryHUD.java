package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class InventoryHUD extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable inventory HUD");
    public IntegerSetting posX = new IntegerSetting("X Position", 500, 0, 3840, "X position");
    public IntegerSetting posY = new IntegerSetting("Y Position", 500, 0, 2160, "Y position");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "HUD scale");
    public BooleanSetting showDurability = new BooleanSetting("Show Durability", true, "Show item durability");
    public BooleanSetting compactView = new BooleanSetting("Compact View", false, "Use compact display");

    public InventoryHUD() {
        super("Inventory HUD", "HUD", "Display inventory information");
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
        json.addProperty("compactView", compactView.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("x")) posX.setValue(json.get("x").getAsInt());
        if (json.has("y")) posY.setValue(json.get("y").getAsInt());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("showDurability")) showDurability.setValue(json.get("showDurability").getAsBoolean());
        if (json.has("compactView")) compactView.setValue(json.get("compactView").getAsBoolean());
    }
}
