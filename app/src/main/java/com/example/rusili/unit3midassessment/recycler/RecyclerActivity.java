package com.example.rusili.unit3midassessment.recycler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rusili.unit3midassessment.R;
import com.example.rusili.unit3midassessment.recycler.adapter.SharedPrefsAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rusi.li on 11/27/17.
 */

public class RecyclerActivity extends AppCompatActivity{
    private List<Object> listOfPrefs = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        getIntentExtra();
        getAllSharedPrefs();

        setupViews();
    }

    private void getIntentExtra() {
        Intent intent = getIntent();
        if (intent != null) {
            String emailStringExtra = intent.getStringExtra(getString(R.string.intent_key_recycler_activity));
        }
    }

    private void getAllSharedPrefs() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preference_key_address), Context.MODE_PRIVATE);
        Map<String, ?> allPrefs = sharedPreferences.getAll();

        for (Map.Entry<String, ?> entry : allPrefs.entrySet()) {
            listOfPrefs.add(entry.getValue());
        }
    }

    private void setupViews() {
        RecyclerView recyclerView = findViewById(R.id.recycler_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new SharedPrefsAdapter(listOfPrefs));
    }
}
