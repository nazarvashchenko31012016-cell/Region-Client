package com.regionclient.module.esp;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class TracersESP extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable tracers ESP");
    public IntegerSetting tracerColor = new IntegerSetting("Color", 0xFFFFFF, 0, 0xFFFFFF, "Tracer color");
    public EnumSetting tracerOrigin = new EnumSetting("Origin", "head", new String[]{"head", "center", "eyes"}, "Tracer line origin");
    public FloatSetting tracerThickness = new FloatSetting("Thickness", 1.0f, 0.5f, 3.0f, "Tracer thickness");

    public TracersESP() {
        super("Tracers", "Render", "Draw tracer lines to targets");
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
        json.addProperty("color", tracerColor.getValue());
        json.addProperty("origin", tracerOrigin.getValue());
        json.addProperty("thickness", tracerThickness.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("color")) tracerColor.setValue(json.get("color").getAsInt());
        if (json.has("origin")) tracerOrigin.setValue(json.get("origin").getAsString());
        if (json.has("thickness")) tracerThickness.setValue(json.get("thickness").getAsFloat());
    }
}
