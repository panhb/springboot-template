package com.panhb.model.base;

import com.google.common.base.Objects;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/8/17
 */
@Data
public class BaseKey {

    private String key1;
    private String key2;
    private String key3;
    private String key4;
    private String key5;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseKey)) return false;
        BaseKey baseKey = (BaseKey) o;
        return java.util.Objects.equals(getKey1(), baseKey.getKey1()) &&
                java.util.Objects.equals(getKey2(), baseKey.getKey2()) &&
                java.util.Objects.equals(getKey3(), baseKey.getKey3()) &&
                java.util.Objects.equals(getKey4(), baseKey.getKey4()) &&
                java.util.Objects.equals(getKey5(), baseKey.getKey5());
    }

    @Override
    public int hashCode() {

        return java.util.Objects.hash(getKey1(), getKey2(), getKey3(), getKey4(), getKey5());
    }
}
