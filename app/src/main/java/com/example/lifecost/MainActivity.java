package com.example.lifecost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lifecost.fragments.CountrySpinnerFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CountrySpinnerFragment.CountrySpinnerData {

    Button checkBtn;
    EditText city;

    String selected_country;

    @Override
    public void onDataPass(String data) {
        selected_country = data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city_text);

        checkBtn = findViewById(R.id.check_button);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("selected_country", selected_country);
                i.putExtra("selected_city", city.getText().toString());
                startActivity(i);
            }
        });
    }




}