package com.example.lifecost.helper;

import com.example.lifecost.BuildConfig;
import com.example.lifecost.ResultActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ResponseReader {

    private static final String API_KEY = BuildConfig.API_KEY;

    public static String getResponse(String url, Map<String,String> params) throws UnsupportedEncodingException {
        HttpURLConnection con = null;
        String requestParams = ParamBuilder.makeString(params);
        String fullUrl = url + requestParams;

        try {
            URL u = new URL(fullUrl);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-RapidAPI-Key", API_KEY);
            con.setRequestProperty("X-RapidAPI-Host", "cost-of-living-and-prices.p.rapidapi.com");
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.setConnectTimeout(10000);
            con.setReadTimeout(10000);
            con.connect();

            int status = con.getResponseCode();

            switch(status) {
                case 200:
                case 201:
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String inputLine;
                    StringBuffer content = new StringBuffer();
                    while((inputLine = reader.readLine()) != null) {
                        content.append(inputLine);
                    }
                    reader.close();
                    return content.toString();
            }

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(con != null) {
                try {
                    con.disconnect();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;

    }

}
