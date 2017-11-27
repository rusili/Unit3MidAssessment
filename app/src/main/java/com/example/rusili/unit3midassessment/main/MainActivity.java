package com.example.rusili.unit3midassessment.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rusili.unit3midassessment.R;
import com.example.rusili.unit3midassessment.recycler.RecyclerActivity;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    private EditText emailEditText;
    private Button saveButton;
    private Button navigateButton;

    private String email = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(getString(R.string.shared_preference_key_address), Context.MODE_PRIVATE);

        setupViews();
        setOnClickListeners();
    }

    private void setupViews() {
        emailEditText = findViewById(R.id.main_email_edittext);
        saveButton = findViewById(R.id.main_save_button);
        navigateButton = findViewById(R.id.main_navigation_button);
    }

    private void setOnClickListeners() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailEditText.getText().toString();
                if (!email.equals("")) {
                    saveEmailInSharedPrefs();
                }

                emailEditText.setText("");
            }
        });

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToRecyclerActivity();
            }
        });
    }

    private void saveEmailInSharedPrefs() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(email, email);
        editor.apply();
    }

    private void intentToRecyclerActivity() {
        Intent toRecyclerActivity = new Intent(MainActivity.this, RecyclerActivity.class);
        toRecyclerActivity.putExtra(getString(R.string.intent_key_recycler_activity), email);
        startActivity(toRecyclerActivity);
    }
}
