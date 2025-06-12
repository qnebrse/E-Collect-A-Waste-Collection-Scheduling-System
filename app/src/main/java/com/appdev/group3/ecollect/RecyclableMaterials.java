package com.appdev.group3.ecollect;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecyclableMaterials extends AppCompatActivity {

    private TextView categoryResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclable_materials);

        // Initialize buttons
        ImageButton homeButton = findViewById(R.id.homeButton5);
        ImageButton newsButton = findViewById(R.id.newsButton5);
        ImageButton searchButton = findViewById(R.id.searchButton5);
        ImageButton profButton = findViewById(R.id.profButton5);

        ImageButton paperButton = findViewById(R.id.paperButton);
        ImageButton plasticButton = findViewById(R.id.plasticButton);
        ImageButton glassButton = findViewById(R.id.glassButton);
        ImageButton metalButton = findViewById(R.id.metalButton);
        ImageButton cartonButton = findViewById(R.id.cartonButton);
        ImageButton organicButton = findViewById(R.id.organicButton);

        // Initialize TextView for displaying the category result
        categoryResult = findViewById(R.id.recy_txt1);

        // Set click listeners for navigation buttons
        homeButton.setOnClickListener(v -> navigateTo(HomePage.class));
        newsButton.setOnClickListener(v -> navigateTo(Bulletin.class));
        searchButton.setOnClickListener(v -> navigateTo(RecyclableMaterials.class));
        profButton.setOnClickListener(v -> navigateTo(UserProfilePanel.class));

        // Set click listeners for category buttons
        paperButton.setOnClickListener(v -> navigateToCategory("Paper"));
        plasticButton.setOnClickListener(v -> navigateToCategory("Plastic"));
        glassButton.setOnClickListener(v -> navigateToCategory("Glass"));
        metalButton.setOnClickListener(v -> navigateToCategory("Metal"));
        cartonButton.setOnClickListener(v -> navigateToCategory("Carton"));
        organicButton.setOnClickListener(v -> navigateToCategory("Organic"));
    }

    @SuppressLint("SetTextI18n")
    private void searchRecyclable(String item) {
        String category = WasteData.getCategory(item);
        categoryResult.setText("Category: " + category);
        Toast.makeText(this, "Category: " + category, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    private void navigateToCategory(String category) {
        Intent intent;
        switch (category) {
            case "Carton":
                intent = new Intent(this, RecyclingCarton.class);
                break;
            case "Glass":
                intent = new Intent(this, RecyclingGlass.class);
                break;
            case "Metal":
                intent = new Intent(this, RecyclingMetal.class);
                break;
            case "Organic":
                intent = new Intent(this, RecyclingOrganic.class);
                break;
            case "Plastic":
                intent = new Intent(this, RecyclingPlastic.class);
                break;
            case "Paper":
                intent = new Intent(this, RecyclingPaper.class);
                break;
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
        startActivity(intent);
        Toast.makeText(this, "Navigating to: " + category, Toast.LENGTH_SHORT).show();
    }

    private void navigateTo(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}