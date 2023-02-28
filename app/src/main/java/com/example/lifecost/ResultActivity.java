package com.example.lifecost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lifecost.helper.TaskLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Data>> {


    private String url = "https://cost-of-living-and-prices.p.rapidapi.com/prices?";
    private Map<String, String> params;

    final int LOADER_ID = 1;

    ViewAdapter adapter;
    List<Data> responseData = new ArrayList<Data>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        params = new HashMap<String,String>();

        String country_data;
        String city_data;

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            country_data = extras.getString("selected_country");
            city_data = extras.getString("selected_city");
        }
        else {
            country_data = "Unidentified country";
            city_data = "Unidentified city";
        }

        params.put("city_name", city_data);
        params.put("country_name", country_data);

        RecyclerView rv = findViewById(R.id.recycler_view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //dummy data
//        responseData.add(new Data("Drinking water", "Restaurant", "JPY", "100"));
//        responseData.add(new Data("Soup", "Restaurant", "JPY", "5000"));
//        responseData.add(new Data("Truffle", "Restaurant", "JPY", "1000000"));
//        responseData.add(new Data(country_data, city_data, null, null));
//        responseData.add(new Data(city_data,country_data,null,null));

        adapter = new ViewAdapter(getApplicationContext(), this.responseData);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public Loader<List<Data>> onCreateLoader(int id, @Nullable Bundle args) {
        return new TaskLoader(ResultActivity.this, url, params);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Data>> loader, List<Data> data) {
         //updates ui here
        if(data != null) {
            for(int i=0;i<data.size();i++) {
                this.responseData.add(data.get(i));
            }
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Data>> loader) {
        adapter.setData(new ArrayList<Data>());
    }
}