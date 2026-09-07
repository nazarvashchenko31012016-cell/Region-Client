package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.IntegerSetting;
import com.google.gson.JsonObject;

public class CustomSun extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable custom sun");
    public IntegerSetting sunColor = new IntegerSetting("Color", 0xFFFFFF, 0, 0xFFFFFF, "Sun color");
    public IntegerSetting sunSize = new IntegerSetting("Size", 20, 5, 100, "Sun size");

    public CustomSun() {
        super("Custom Sun", "Visuals", "Customize sun appearance");
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
        json.addProperty("sunColor", sunColor.getValue());
        json.addProperty("sunSize", sunSize.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("sunColor")) {
            sunColor.setValue(json.get("sunColor").getAsInt());
        }
        if (json.has("sunSize")) {
            sunSize.setValue(json.get("sunSize").getAsInt());
        }
    }
}
