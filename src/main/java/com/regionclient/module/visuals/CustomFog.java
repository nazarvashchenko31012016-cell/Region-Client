package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.FloatSetting;
import com.google.gson.JsonObject;

public class CustomFog extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable custom fog");
    public FloatSetting fogDistance = new FloatSetting("Fog Distance", 100.0f, 10.0f, 500.0f, "Fog render distance");
    public FloatSetting fogDensity = new FloatSetting("Fog Density", 0.5f, 0.0f, 1.0f, "Fog density");

    public CustomFog() {
        super("Custom Fog", "Visuals", "Customize fog rendering");
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
        json.addProperty("fogDistance", fogDistance.getValue());
        json.addProperty("fogDensity", fogDensity.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("fogDistance")) {
            fogDistance.setValue(json.get("fogDistance").getAsFloat());
        }
        if (json.has("fogDensity")) {
            fogDensity.setValue(json.get("fogDensity").getAsFloat());
        }
    }
}
