package com.regionclient.setting;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class IntegerSetting extends Setting<Integer> {
    private int min;
    private int max;

    public IntegerSetting(String name, Integer value, Integer min, Integer max, String description) {
        super(name, value, description);
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive(getValue());
    }

    @Override
    public void fromJson(JsonElement json) {
        setValue(json.getAsInt());
    }
}
