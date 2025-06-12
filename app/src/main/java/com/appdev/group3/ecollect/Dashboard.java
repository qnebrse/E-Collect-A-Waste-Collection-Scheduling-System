package com.appdev.group3.ecollect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize buttons
        ImageButton schedButton = findViewById(R.id.sched_button);
        ImageButton wasteButton = findViewById(R.id.waste_button);
        ImageButton recyButton = findViewById(R.id.recy_button);
        ImageButton homeButton = findViewById(R.id.homeButton);
        ImageButton newsButton = findViewById(R.id.newsButton);
        ImageButton searchButton = findViewById(R.id.searchButton);
        ImageButton profButton = findViewById(R.id.profButton);

        // Set click listeners for buttons
        schedButton.setOnClickListener(v -> {
            Intent schedIntent = new Intent(Dashboard.this, CalendarMonthly.class);
            startActivity(schedIntent);
        });
        wasteButton.setOnClickListener(v -> {
            Intent wasteIntent = new Intent(Dashboard.this, WasteSegregationSearch.class);
            startActivity(wasteIntent);
        });

searchButton.setOnClickListener(v -> {
    Intent searchIntent = new Intent(Dashboard.this, RecyclingCenterMap.class);
    startActivity(searchIntent);
    });
        recyButton.setOnClickListener(v -> openRecyclableInformation());
        homeButton.setOnClickListener(v -> openHome());
        newsButton.setOnClickListener(v -> openNews());
        searchButton.setOnClickListener(v -> openRecyclingCenterMap());
        profButton.setOnClickListener(v -> openUserProfilePanel());
    }




    private void openNews() {
        Intent intent = new Intent(Dashboard.this, Bulletin.class);
        startActivity(intent);
    }


    private void openHome() {
        Intent intent = new Intent(Dashboard.this, HomePage.class);
        startActivity(intent);
    }


    private void openRecyclableInformation() {
        Intent intent = new Intent(Dashboard.this, RecyclableMaterials.class);
        startActivity(intent);
    }


    private void openUserProfilePanel() {

            Intent intent = new Intent(Dashboard.this, UserProfilePanel.class);
            startActivity(intent);
    }


    private void openRecyclingCenterMap() {

        Intent intent = new Intent(Dashboard.this, RecyclingCenterMap.class);
        startActivity(intent);
    }



}