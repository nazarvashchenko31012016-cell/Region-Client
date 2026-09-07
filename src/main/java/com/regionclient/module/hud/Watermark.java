package com.regionclient.module.hud;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class Watermark extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", true, "Enable watermark");
    public StringSetting watermarkText = new StringSetting("Text", "Region Client", "Watermark text");
    public IntegerSetting posX = new IntegerSetting("X Position", 10, 0, 3840, "X position");
    public IntegerSetting posY = new IntegerSetting("Y Position", 10, 0, 2160, "Y position");
    public FloatSetting scale = new FloatSetting("Scale", 1.0f, 0.5f, 3.0f, "Text scale");
    public IntegerSetting textColor = new IntegerSetting("Color", 0xFF7B2CBF, 0, 0xFFFFFF, "Text color");
    public BooleanSetting enableGradient = new BooleanSetting("Gradient", true, "Enable gradient effect");
    public BooleanSetting enableAnimation = new BooleanSetting("Animation", true, "Enable animation");
    public EnumSetting style = new EnumSetting("Style", "modern", new String[]{"classic", "modern", "minimal", "glow"}, "Text style");

    public Watermark() {
        super("Watermark", "HUD", "Display watermark");
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
        json.addProperty("text", watermarkText.getValue());
        json.addProperty("x", posX.getValue());
        json.addProperty("y", posY.getValue());
        json.addProperty("scale", scale.getValue());
        json.addProperty("color", textColor.getValue());
        json.addProperty("gradient", enableGradient.getValue());
        json.addProperty("animation", enableAnimation.getValue());
        json.addProperty("style", style.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("text")) watermarkText.setValue(json.get("text").getAsString());
        if (json.has("x")) posX.setValue(json.get("x").getAsInt());
        if (json.has("y")) posY.setValue(json.get("y").getAsInt());
        if (json.has("scale")) scale.setValue(json.get("scale").getAsFloat());
        if (json.has("color")) textColor.setValue(json.get("color").getAsInt());
        if (json.has("gradient")) enableGradient.setValue(json.get("gradient").getAsBoolean());
        if (json.has("animation")) enableAnimation.setValue(json.get("animation").getAsBoolean());
        if (json.has("style")) style.setValue(json.get("style").getAsString());
    }
}
