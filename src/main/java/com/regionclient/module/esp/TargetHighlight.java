package com.regionclient.module.esp;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class TargetHighlight extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable target highlight");
    public IntegerSetting highlightColor = new IntegerSetting("Color", 0xFFFFFF, 0, 0xFFFFFF, "Highlight color");
    public FloatSetting highlightAlpha = new FloatSetting("Alpha", 1.0f, 0.0f, 1.0f, "Highlight transparency");
    public FloatSetting pulseSpeed = new FloatSetting("Pulse Speed", 1.0f, 0.1f, 3.0f, "Pulse animation speed");

    public TargetHighlight() {
        super("Target Highlight", "Render", "Highlight current target");
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
        json.addProperty("color", highlightColor.getValue());
        json.addProperty("alpha", highlightAlpha.getValue());
        json.addProperty("pulseSpeed", pulseSpeed.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("color")) highlightColor.setValue(json.get("color").getAsInt());
        if (json.has("alpha")) highlightAlpha.setValue(json.get("alpha").getAsFloat());
        if (json.has("pulseSpeed")) pulseSpeed.setValue(json.get("pulseSpeed").getAsFloat());
    }
}
