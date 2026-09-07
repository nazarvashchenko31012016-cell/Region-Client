package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.IntegerSetting;
import com.google.gson.JsonObject;

public class WorldColor extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable world color change");
    public IntegerSetting worldColor = new IntegerSetting("Color", 0xFFFFFF, 0, 0xFFFFFF, "World color");
    public IntegerSetting saturation = new IntegerSetting("Saturation", 100, 0, 200, "Color saturation");

    public WorldColor() {
        super("World Color", "Visuals", "Change world color");
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
        json.addProperty("worldColor", worldColor.getValue());
        json.addProperty("saturation", saturation.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("worldColor")) {
            worldColor.setValue(json.get("worldColor").getAsInt());
        }
        if (json.has("saturation")) {
            saturation.setValue(json.get("saturation").getAsInt());
        }
    }
}
