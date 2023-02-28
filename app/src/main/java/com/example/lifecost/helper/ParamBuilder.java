package com.example.lifecost.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ParamBuilder {

    public static String makeString(Map<String, String> param) throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();

        for(Map.Entry<String, String> entry : param.entrySet()) {
            builder.append(URLEncoder.encode(entry.getKey(),"UTF-8"));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue(),"UTF-8"));
            builder.append("&");
        }

        String result = builder.toString();

        if(result.length() > 0) {
            return result.substring(0, result.length()-1);
        }
        return result;
    }

}
