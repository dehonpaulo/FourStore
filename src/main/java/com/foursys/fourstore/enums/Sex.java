package com.foursys.fourstore.enums;

import java.util.HashMap;
import java.util.Map;

public enum Sex {
    M,
    F,
    U;

    private static final Map<String, Sex> sexMap = new HashMap<>();

    static {
        for(Sex sex : Sex.values()) {
            sexMap.put(sex.toString(), sex);
        }
    }

    public static Sex getFromString(String sex) {
        if(!sexMap.containsKey(sex)) return null;
        return sexMap.get(sex);
    }
}
