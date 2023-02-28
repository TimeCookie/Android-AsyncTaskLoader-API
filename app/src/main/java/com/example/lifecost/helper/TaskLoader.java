package com.example.lifecost.helper;

import androidx.loader.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.lifecost.Data;
import com.example.lifecost.ResultActivity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskLoader extends AsyncTaskLoader<List<Data>> {

    private String mData;
    private String url;
    private Map<String,String> params;

    public boolean hasResult;

    List<Data> responseElements = new ArrayList<Data>();

    public TaskLoader(@NonNull Context context, String url, Map<String,String> params) {
        super(context);
        this.url = url;
        this.params = params;
    }

    @Override
    public List<Data> loadInBackground() {

        try {
            mData = ResponseReader.getResponse(url, params);

            JSONObject request = new JSONObject(mData);
            JSONArray prices = request.getJSONArray("prices");
            for(int i=0;i<prices.length();i++) {
                JSONObject item = prices.getJSONObject(i);

                String newItemName = item.getString("item_name");
                String newItemCategory = item.getString("category_name");
                String newCurrencyCode = item.getString("currency_code");
                String newAveragePrice = Double.toString(item.getDouble("avg"));

                Data newItem = new Data(newItemName, newItemCategory, newCurrencyCode, newAveragePrice);

                responseElements.add(newItem);
            }

            return responseElements;
//            return mData;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return responseElements;
//        return mData;

    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
