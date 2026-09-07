package com.regionclient.module.esp;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class TargetESP extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable target ESP");
    public EnumSetting mode = new EnumSetting("Mode", "box", new String[]{"box", "3d_box", "outline", "glow", "circle", "tracer", "highlight"}, "ESP mode");
    public IntegerSetting espColor = new IntegerSetting("Color", 0xFF7B2CBF, 0, 0xFFFFFF, "ESP color");
    public FloatSetting espThickness = new FloatSetting("Thickness", 2.0f, 0.5f, 5.0f, "Line thickness");
    public FloatSetting espAlpha = new FloatSetting("Alpha", 1.0f, 0.0f, 1.0f, "Transparency");
    public FloatSetting animationSpeed = new FloatSetting("Animation Speed", 1.0f, 0.1f, 3.0f, "Animation speed");
    public BooleanSetting fadeAnimation = new BooleanSetting("Fade Animation", true, "Enable fade animation");
    public BooleanSetting healthBar = new BooleanSetting("Health Bar", true, "Show health bar");
    public BooleanSetting showDistance = new BooleanSetting("Show Distance", true, "Show distance to target");

    public TargetESP() {
        super("Target ESP", "Render", "ESP for current target");
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
        json.addProperty("mode", mode.getValue());
        json.addProperty("color", espColor.getValue());
        json.addProperty("thickness", espThickness.getValue());
        json.addProperty("alpha", espAlpha.getValue());
        json.addProperty("animationSpeed", animationSpeed.getValue());
        json.addProperty("fadeAnimation", fadeAnimation.getValue());
        json.addProperty("healthBar", healthBar.getValue());
        json.addProperty("showDistance", showDistance.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("mode")) mode.setValue(json.get("mode").getAsString());
        if (json.has("color")) espColor.setValue(json.get("color").getAsInt());
        if (json.has("thickness")) espThickness.setValue(json.get("thickness").getAsFloat());
        if (json.has("alpha")) espAlpha.setValue(json.get("alpha").getAsFloat());
        if (json.has("animationSpeed")) animationSpeed.setValue(json.get("animationSpeed").getAsFloat());
        if (json.has("fadeAnimation")) fadeAnimation.setValue(json.get("fadeAnimation").getAsBoolean());
        if (json.has("healthBar")) healthBar.setValue(json.get("healthBar").getAsBoolean());
        if (json.has("showDistance")) showDistance.setValue(json.get("showDistance").getAsBoolean());
    }
}
