package com.regionclient.setting;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class FloatSetting extends Setting<Float> {
    private float min;
    private float max;

    public FloatSetting(String name, Float value, Float min, Float max, String description) {
        super(name, value, description);
        this.min = min;
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive(getValue());
    }

    @Override
    public void fromJson(JsonElement json) {
        setValue(json.getAsFloat());
    }
}
