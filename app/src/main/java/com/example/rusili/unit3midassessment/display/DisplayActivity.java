package com.example.rusili.unit3midassessment.display;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.rusili.unit3midassessment.R;

/**
 * Created by rusi.li on 11/27/17.
 */

public class DisplayActivity extends AppCompatActivity {
    private TextView textViewStringExtra;
    private TextView textViewStringExtraLength;

    private String objectStringExtra = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        getIntentExtra();
        setupViews(objectStringExtra);
    }

    private void getIntentExtra() {
        Intent intent = getIntent();
        if (intent != null) {
            objectStringExtra = intent.getStringExtra(getString(R.string.intent_key_display_activity));
        }
    }

    private void setupViews(String objectStringExtra) {
        textViewStringExtra = findViewById(R.id.display_string_extra_value);
        textViewStringExtraLength = findViewById(R.id.display_string_extra_value_length);

        textViewStringExtra.setText(objectStringExtra);
        textViewStringExtraLength.setText(String.valueOf(objectStringExtra.length()));
    }
}
