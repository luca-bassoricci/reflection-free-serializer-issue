package org.acme;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ItemId
{
    final int value;

    @JsonCreator
    public ItemId(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @JsonValue
    public String format() {
        return "ItemId:" + value;
    }
}
