package com.regionclient.module;

import com.google.gson.JsonObject;

public abstract class Module {
    private String name;
    private String category;
    private String description;
    private boolean enabled;
    private int keyCode;

    public Module(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.enabled = false;
        this.keyCode = 0;
    }

    public abstract void onTick();
    public abstract void onRender();
    public abstract void onKeyPress(int keyCode);
    public abstract void onEnable();
    public abstract void onDisable();

    public void toggle() {
        if (enabled) {
            disable();
        } else {
            enable();
        }
    }

    public void enable() {
        this.enabled = true;
        onEnable();
    }

    public void disable() {
        this.enabled = false;
        onDisable();
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public abstract JsonObject toJson();
    public abstract void fromJson(JsonObject json);
}
