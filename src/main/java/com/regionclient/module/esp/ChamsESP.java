package com.regionclient.module.esp;

import com.regionclient.module.Module;
import com.regionclient.setting.*;
import com.google.gson.JsonObject;

public class ChamsESP extends Module {
    public BooleanSetting enabled = new BooleanSetting("Enabled", false, "Enable chams ESP");
    public IntegerSetting chamsColor = new IntegerSetting("Color", 0xFF00FF, 0, 0xFFFFFF, "Chams color");
    public BooleanSetting wireframe = new BooleanSetting("Wireframe", false, "Enable wireframe mode");
    public FloatSetting chamsAlpha = new FloatSetting("Alpha", 0.5f, 0.0f, 1.0f, "Chams transparency");

    public ChamsESP() {
        super("Chams", "Render", "Display targets through walls");
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
        json.addProperty("color", chamsColor.getValue());
        json.addProperty("wireframe", wireframe.getValue());
        json.addProperty("alpha", chamsAlpha.getValue());
        return json;
    }

    @Override
    public void fromJson(JsonObject json) {
        if (json.has("color")) chamsColor.setValue(json.get("color").getAsInt());
        if (json.has("wireframe")) wireframe.setValue(json.get("wireframe").getAsBoolean());
        if (json.has("alpha")) chamsAlpha.setValue(json.get("alpha").getAsFloat());
    }
}
