package com.regionclient.module.visuals;

import com.regionclient.module.Module;
import com.regionclient.setting.BooleanSetting;
import com.regionclient.setting.EnumSetting;
import com.google.gson.JsonObject;

public class WeatherChanger extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable weather changer");
    public EnumSetting weather = new EnumSetting("Weather", "clear", new String[]{"clear", "rain", "thunder"}, "Weather type");

    public WeatherChanger() {
        super("Weather Changer", "Visuals", "Change world weather");
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
        json.addProperty("weather", weather.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("weather")) {
            weather.setValue(json.get("weather").getAsString());
        }
    }
}
