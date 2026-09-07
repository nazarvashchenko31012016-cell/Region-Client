package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.IntegerSetting;
import com.google.gson.JsonObject;

public class CustomSky extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable custom sky");
    public IntegerSetting skyColor = new IntegerSetting("Color", 0xFF7B2CBF, 0, 0xFFFFFF, "Sky color");

    public CustomSky() {
        super("Custom Sky", "Visuals", "Customize the sky appearance");
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
        json.addProperty("skyColor", skyColor.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("skyColor")) {
            skyColor.setValue(json.get("skyColor").getAsInt());
        }
    }
}
