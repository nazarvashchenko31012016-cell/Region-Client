package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class TargetHUD extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", true, "Enable target HUD");
    public EnumSetting hudStyle = new EnumSetting("Style", "modern", new String[]{"classic", "modern", "compact", "minimal", "circle"}, "HUD style");
    public IntegerSetting posX = new IntegerSetting("X Position", 500, 0, 3840, "X position");
    public IntegerSetting posY = new IntegerSetting("Y Position", 100, 0, 2160, "Y position");
    public FloatSetting hudScale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "HUD scale");
    public BooleanSetting showName = new BooleanSetting("Show Name", true, "Show target name");
    public BooleanSetting showHealth = new BooleanSetting("Show Health", true, "Show health value");
    public BooleanSetting showHealthBar = new BooleanSetting("Show Health Bar", true, "Show health bar");
    public BooleanSetting showArmor = new BooleanSetting("Show Armor", true, "Show armor");
    public BooleanSetting showDistance = new BooleanSetting("Show Distance", true, "Show distance");
    public BooleanSetting showHead = new BooleanSetting("Show Head", true, "Show player head");

    public TargetHUD() {
        super("Target HUD", "HUD", "Display target information");
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
        json.addProperty("style", hudStyle.getValue());
        json.addProperty("x", posX.getValue());
        json.addProperty("y", posY.getValue());
        json.addProperty("scale", hudScale.getValue());
        json.addProperty("showName", showName.getValue());
        json.addProperty("showHealth", showHealth.getValue());
        json.addProperty("showHealthBar", showHealthBar.getValue());
        json.addProperty("showArmor", showArmor.getValue());
        json.addProperty("showDistance", showDistance.getValue());
        json.addProperty("showHead", showHead.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("style")) hudStyle.setValue(json.get("style").getAsString());
        if (json.has("x")) posX.setValue(json.get("x").getAsInt());
        if (json.has("y")) posY.setValue(json.get("y").getAsInt());
        if (json.has("scale")) hudScale.setValue(json.get("scale").getAsFloat());
        if (json.has("showName")) showName.setValue(json.get("showName").getAsBoolean());
        if (json.has("showHealth")) showHealth.setValue(json.get("showHealth").getAsBoolean());
        if (json.has("showHealthBar")) showHealthBar.setValue(json.get("showHealthBar").getAsBoolean());
        if (json.has("showArmor")) showArmor.setValue(json.get("showArmor").getAsBoolean());
        if (json.has("showDistance")) showDistance.setValue(json.get("showDistance").getAsBoolean());
        if (json.has("showHead")) showHead.setValue(json.get("showHead").getAsBoolean());
    }
}
