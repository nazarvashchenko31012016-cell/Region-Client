package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.FloatSetting;
import com.google.gson.JsonObject;

public class FullBright extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable fullbright");
    public FloatSetting brightness = new FloatSetting("Brightness", 1.0f, 0.0f, 2.0f, "Light level");

    public FullBright() {
        super("FullBright", "Visuals", "Increase world brightness");
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
        json.addProperty("brightness", brightness.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("brightness")) {
            brightness.setValue(json.get("brightness").getAsFloat());
        }
    }
}
