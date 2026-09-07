package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.IntegerSetting;
import com.google.gson.JsonObject;

public class TimeChanger extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable time changer");
    public IntegerSetting time = new IntegerSetting("Time", 6000, 0, 24000, "World time");

    public TimeChanger() {
        super("Time Changer", "Visuals", "Change world time");
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
        json.addProperty("time", time.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("time")) {
            time.setValue(json.get("time").getAsInt());
        }
    }
}
