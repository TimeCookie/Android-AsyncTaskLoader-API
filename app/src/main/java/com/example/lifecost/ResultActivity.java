package com.example.lifecost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private String api_key = BuildConfig.API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

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

        RecyclerView rv = findViewById(R.id.recycler_view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        List<Data> data = new ArrayList<Data>();
        data.add(new Data("Drinking water", "Restaurant", "JPY", "100"));
        data.add(new Data("Soup", "Restaurant", "JPY", "5000"));
        data.add(new Data("Truffle", "Restaurant", "JPY", "1000000"));
        data.add(new Data(country_data, city_data, null, null));

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ViewAdapter(getApplicationContext(), data));
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

}