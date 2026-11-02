package com.betacom.jpa.utils;

import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

    // Metodo per decodificare i parametri passati come stringa (es. "targa=AB123CD,cc=1900,...")
    public static Map<String, String> decodeParamers(String params) {
        Map<String, String> map = new HashMap<>();
        if (params == null || params.trim().isEmpty()) {
            return map;
        }

        // Divide i parametri in base alla virgola 
        String[] pairs = params.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                map.put(keyValue[0].trim().toLowerCase(), keyValue[1].trim());
            } else if (keyValue.length == 1) {
                map.put(keyValue[0].trim().toLowerCase(), "");
            }
        }
        return map;
    }

}
