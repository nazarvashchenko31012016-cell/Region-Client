package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class CustomScoreboard extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable custom scoreboard");
    public BooleanSetting replaceDefault = new BooleanSetting("Replace Default", true, "Replace default scoreboard");
    public IntegerSetting scoreColor = new IntegerSetting("Color", 0xFFFFFF, 0, 0xFFFFFF, "Scoreboard text color");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "Scoreboard scale");
    public BooleanSetting showTeamColors = new BooleanSetting("Show Team Colors", true, "Display team colors");

    public CustomScoreboard() {
        super("Custom Scoreboard", "HUD", "Customize scoreboard display");
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
        json.addProperty("replaceDefault", replaceDefault.getValue());
        json.addProperty("color", scoreColor.getValue());
        json.addProperty("scale", scale.getValue());
        json.addProperty("showTeamColors", showTeamColors.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("replaceDefault")) replaceDefault.setValue(json.get("replaceDefault").getAsBoolean());
        if (json.has("color")) scoreColor.setValue(json.get("color").getAsInt());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("showTeamColors")) showTeamColors.setValue(json.get("showTeamColors").getAsBoolean());
    }
}
