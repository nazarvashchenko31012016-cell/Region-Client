package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.FloatSetting;
import com.google.gson.JsonObject;

public class CustomClouds extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable custom clouds");
    public FloatSetting cloudHeight = new FloatSetting("Height", 192.0f, 64.0f, 256.0f, "Cloud height");
    public FloatSetting cloudDensity = new FloatSetting("Density", 1.0f, 0.0f, 2.0f, "Cloud density");

    public CustomClouds() {
        super("Custom Clouds", "Visuals", "Customize cloud rendering");
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
        json.addProperty("cloudHeight", cloudHeight.getValue());
        json.addProperty("cloudDensity", cloudDensity.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("cloudHeight")) {
            cloudHeight.setValue(json.get("cloudHeight").getAsFloat());
        }
        if (json.has("cloudDensity")) {
            cloudDensity.setValue(json.get("cloudDensity").getAsFloat());
        }
    }
}
