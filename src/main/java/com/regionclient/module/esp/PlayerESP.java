package com.regionclient.module.esp;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class PlayerESP extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable player ESP");
    public BooleanSetting showBox = new BooleanSetting("Box", true, "Show box ESP");
    public BooleanSetting showOutline = new BooleanSetting("Outline", false, "Show outline");
    public BooleanSetting showTracer = new BooleanSetting("Tracer", false, "Show tracer lines");
    public IntegerSetting espColor = new IntegerSetting("Color", 0xFF0000, 0, 0xFFFFFF, "ESP color");
    public FloatSetting espThickness = new FloatSetting("Thickness", 2.0f, 0.5f, 5.0f, "Line thickness");
    public FloatSetting maxDistance = new FloatSetting("Max Distance", 100.0f, 10.0f, 500.0f, "Maximum render distance");

    public PlayerESP() {
        super("Player ESP", "Render", "ESP for all players");
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
        json.addProperty("box", showBox.getValue());
        json.addProperty("outline", showOutline.getValue());
        json.addProperty("tracer", showTracer.getValue());
        json.addProperty("color", espColor.getValue());
        json.addProperty("thickness", espThickness.getValue());
        json.addProperty("maxDistance", maxDistance.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("box")) showBox.setValue(json.get("box").getAsBoolean());
        if (json.has("outline")) showOutline.setValue(json.get("outline").getAsBoolean());
        if (json.has("tracer")) showTracer.setValue(json.get("tracer").getAsBoolean());
        if (json.has("color")) espColor.setValue(json.get("color").getAsInt());
        if (json.has("thickness")) espThickness.setValue(json.get("thickness").getAsFloat());
        if (json.has("maxDistance")) maxDistance.setValue(json.get("maxDistance").getAsFloat());
    }
}
