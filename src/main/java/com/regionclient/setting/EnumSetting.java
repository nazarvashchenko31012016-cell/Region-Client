package com.regionclient.setting;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class EnumSetting extends Setting<String> {
    private String[] options;

    public EnumSetting(String name, String value, String[] options, String description) {
        super(name, value, description);
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive(getValue());
    }

    @Override
    public void fromJson(JsonElement json) {
        setValue(json.getAsString());
    }
}
