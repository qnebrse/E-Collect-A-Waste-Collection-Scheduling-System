package com.appdev.group3.ecollect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bulletin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bulletin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainn), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        ImageButton homeButton4 = findViewById(R.id.homeButton4);
        ImageButton searchButton4 = findViewById(R.id.newsButton4);
        ImageButton profButton4 = findViewById(R.id.profButton4);

        // Set button click listeners
        homeButton4.setOnClickListener(v -> openHome());
        searchButton4.setOnClickListener(v -> openRecyclingCenterMap());
        profButton4.setOnClickListener(v -> openUserProfilePanel());

        // Additional click listeners if needed
        homeButton4.setOnClickListener(v -> {
            Intent schedIntent = new Intent(Bulletin.this, HomePage.class);
            startActivity(schedIntent);
        });
        searchButton4.setOnClickListener(v -> {
            Intent schedIntent = new Intent(Bulletin.this, RecyclingCenterMap.class);
            startActivity(schedIntent);
        });
        profButton4.setOnClickListener(v -> {
            Intent wasteIntent = new Intent(Bulletin.this, UserProfilePanel.class);
            startActivity(wasteIntent);
        });
    }

    private void openHome() {
        Intent intent = new Intent(Bulletin.this, HomePage.class);
        startActivity(intent);
    }

    private void openUserProfilePanel() {
        Intent intent = new Intent(Bulletin.this, UserProfilePanel.class);
        startActivity(intent);
    }

    private void openRecyclingCenterMap() {
        Intent intent = new Intent(Bulletin.this, RecyclingCenterMap.class);
        startActivity(intent);
    }
}