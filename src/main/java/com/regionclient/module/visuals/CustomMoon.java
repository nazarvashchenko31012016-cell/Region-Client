package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.IntegerSetting;
import com.google.gson.JsonObject;

public class CustomMoon extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable custom moon");
    public IntegerSetting moonColor = new IntegerSetting("Color", 0xFFFFFF, 0, 0xFFFFFF, "Moon color");
    public IntegerSetting moonSize = new IntegerSetting("Size", 15, 5, 100, "Moon size");

    public CustomMoon() {
        super("Custom Moon", "Visuals", "Customize moon appearance");
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
        json.addProperty("moonColor", moonColor.getValue());
        json.addProperty("moonSize", moonSize.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("moonColor")) {
            moonColor.setValue(json.get("moonColor").getAsInt());
        }
        if (json.has("moonSize")) {
            moonSize.setValue(json.get("moonSize").getAsInt());
        }
    }
}
