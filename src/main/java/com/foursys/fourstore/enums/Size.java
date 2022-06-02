package com.foursys.fourstore.enums;

import java.util.HashMap;
import java.util.Map;

public enum Size {
    PP,
    P,
    M,
    G,
    GG;

    private static final Map<String, Size> sizeMap = new HashMap<>();

    static {
        for(Size size : Size.values()) {
            sizeMap.put(size.toString(), size);
        }
    }

    public static Size getFromString(String size) {
        if(!sizeMap.containsKey(size)) return null;
        return sizeMap.get(size);
    }
}
