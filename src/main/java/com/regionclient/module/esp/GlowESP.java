package com.regionclient.module.esp;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class GlowESP extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable glow ESP");
    public IntegerSetting glowColor = new IntegerSetting("Color", 0x00FF00, 0, 0xFFFFFF, "Glow color");
    public FloatSetting glowIntensity = new FloatSetting("Intensity", 1.0f, 0.1f, 3.0f, "Glow intensity");
    public FloatSetting glowRadius = new FloatSetting("Radius", 2.0f, 0.5f, 5.0f, "Glow radius");

    public GlowESP() {
        super("Glow", "Render", "Add glow effect to targets");
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
        json.addProperty("color", glowColor.getValue());
        json.addProperty("intensity", glowIntensity.getValue());
        json.addProperty("radius", glowRadius.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("color")) glowColor.setValue(json.get("color").getAsInt());
        if (json.has("intensity")) glowIntensity.setValue(json.get("intensity").getAsFloat());
        if (json.has("radius")) glowRadius.setValue(json.get("radius").getAsFloat());
    }
}
