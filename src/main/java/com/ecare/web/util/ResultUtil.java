package com.ecare.web.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.StreamHandler;

/**
 * Created by L on 2016/7/13.
 */
public class ResultUtil {
    private static Map<String, Object> map;
    public static Map<String, Object> getResult(int code, String message, Object data) {
        if (map == null)
            map = new LinkedHashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", data);
        return map;
    }

}
