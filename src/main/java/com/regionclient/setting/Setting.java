package com.regionclient.setting;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public abstract class Setting<T> {
    private String name;
    private T value;
    private T defaultValue;
    private String description;

    public Setting(String name, T value, String description) {
        this.name = name;
        this.value = value;
        this.defaultValue = value;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public abstract JsonElement toJson();
    public abstract void fromJson(JsonElement json);
}
