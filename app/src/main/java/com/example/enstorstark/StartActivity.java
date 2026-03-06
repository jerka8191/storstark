package com.example.enstorstark;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartActivity extends AppCompatActivity {

    private static String name = StartActivity.class.getSimpleName();
    private Button pubsButton;
    private Button mapButton;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pubsButton = findViewById(R.id.button_pubs);
        mapButton = findViewById(R.id.button_map);
        searchButton = findViewById(R.id.button_search);
        pubsButton.setOnClickListener(v -> {
            Log.d(name, "pubs-button pressed");
            launchPubsActivity(v);
        });
        mapButton.setOnClickListener(v -> Log.d(name, "map-button pressed"));
        searchButton.setOnClickListener(v -> Log.d(name, "search-button pressed"));
    }

    private void launchPubsActivity(View view) {
        Intent intent = new Intent(this, PubsActivity.class);
        startActivity(intent);
    }
}