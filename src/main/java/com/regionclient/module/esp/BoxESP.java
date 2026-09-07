package com.regionclient.module.esp;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class BoxESP extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable box ESP");
    public IntegerSetting espColor = new IntegerSetting("Color", 0xFF7B2CBF, 0, 0xFFFFFF, "Box color");
    public FloatSetting boxThickness = new FloatSetting("Thickness", 2.0f, 0.5f, 5.0f, "Box line thickness");
    public FloatSetting espAlpha = new FloatSetting("Alpha", 0.8f, 0.0f, 1.0f, "Box transparency");

    public BoxESP() {
        super("Box ESP", "Render", "Draw boxes around targets");
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
        json.addProperty("color", espColor.getValue());
        json.addProperty("thickness", boxThickness.getValue());
        json.addProperty("alpha", espAlpha.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("color")) espColor.setValue(json.get("color").getAsInt());
        if (json.has("thickness")) boxThickness.setValue(json.get("thickness").getAsFloat());
        if (json.has("alpha")) espAlpha.setValue(json.get("alpha").getAsFloat());
    }
}
