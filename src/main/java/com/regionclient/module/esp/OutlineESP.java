package com.regionclient.module.esp;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class OutlineESP extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable outline ESP");
    public IntegerSetting outlineColor = new IntegerSetting("Color", 0x00FFFF, 0, 0xFFFFFF, "Outline color");
    public FloatSetting outlineThickness = new FloatSetting("Thickness", 2.0f, 0.5f, 5.0f, "Outline thickness");
    public FloatSetting outlineAlpha = new FloatSetting("Alpha", 1.0f, 0.0f, 1.0f, "Outline transparency");

    public OutlineESP() {
        super("Outline ESP", "Render", "Draw outlines around targets");
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
        json.addProperty("color", outlineColor.getValue());
        json.addProperty("thickness", outlineThickness.getValue());
        json.addProperty("alpha", outlineAlpha.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("color")) outlineColor.setValue(json.get("color").getAsInt());
        if (json.has("thickness")) outlineThickness.setValue(json.get("thickness").getAsFloat());
        if (json.has("alpha")) outlineAlpha.setValue(json.get("alpha").getAsFloat());
    }
}
