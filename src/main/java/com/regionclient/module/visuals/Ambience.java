package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.FloatSetting;
import com.google.gson.JsonObject;

public class Ambience extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable ambience effects");
    public FloatSetting ambienceIntensity = new FloatSetting("Intensity", 1.0f, 0.0f, 2.0f, "Ambience intensity");

    public Ambience() {
        super("Ambience", "Visuals", "Adjust world ambience");
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
        json.addProperty("ambienceIntensity", ambienceIntensity.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("ambienceIntensity")) {
            ambienceIntensity.setValue(json.get("ambienceIntensity").getAsFloat());
        }
    }
}
