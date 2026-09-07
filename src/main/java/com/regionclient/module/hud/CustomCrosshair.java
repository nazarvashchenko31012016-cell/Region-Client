package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class CustomCrosshair extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable custom crosshair");
    public EnumSetting crosshairStyle = new EnumSetting("Style", "cross", new String[]{"cross", "dot", "circle", "triangle", "square"}, "Crosshair style");
    public IntegerSetting crosshairColor = new IntegerSetting("Color", 0xFF7B2CBF, 0, 0xFFFFFF, "Crosshair color");
    public FloatSetting crosshairSize = new FloatSetting("Size", 1.0f, 0.1f, 3.0f, "Crosshair size");
    public BooleanSetting dynamicCrosshair = new BooleanSetting("Dynamic", true, "Scale with spread");

    public CustomCrosshair() {
        super("Custom Crosshair", "HUD", "Customize crosshair appearance");
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
        json.addProperty("style", crosshairStyle.getValue());
        json.addProperty("color", crosshairColor.getValue());
        json.addProperty("size", crosshairSize.getValue());
        json.addProperty("dynamic", dynamicCrosshair.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("style")) crosshairStyle.setValue(json.get("style").getAsString());
        if (json.has("color")) crosshairColor.setValue(json.get("color").getAsInt());
        if (json.has("size")) crosshairSize.setValue(json.get("size").getAsFloat());
        if (json.has("dynamic")) dynamicCrosshair.setValue(json.get("dynamic").getAsBoolean());
    }
}
