package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class CustomChat extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable custom chat");
    public IntegerSetting chatColor = new IntegerSetting("Color", 0xFFFFFF, 0, 0xFFFFFF, "Chat text color");
    public FloatSetting chatOpacity = new FloatSetting("Opacity", 1.0f, 0.0f, 1.0f, "Chat transparency");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 2.0f, "Chat scale");
    public BooleanSetting shadedBackground = new BooleanSetting("Shaded Background", true, "Show chat background");

    public CustomChat() {
        super("Custom Chat", "HUD", "Customize chat appearance");
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
        json.addProperty("color", chatColor.getValue());
        json.addProperty("opacity", chatOpacity.getValue());
        json.addProperty("scale", scale.getValue());
        json.addProperty("shadedBackground", shadedBackground.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("color")) chatColor.setValue(json.get("color").getAsInt());
        if (json.has("opacity")) chatOpacity.setValue(json.get("opacity").getAsFloat());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("shadedBackground")) shadedBackground.setValue(json.get("shadedBackground").getAsBoolean());
    }
}
