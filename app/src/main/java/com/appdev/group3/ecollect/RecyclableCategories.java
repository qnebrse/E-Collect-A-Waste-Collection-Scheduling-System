package com.appdev.group3.ecollect;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class RecyclableCategories extends AppCompatActivity {

    private ImageButton recymats_button;
    private ImageButton junkshop_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclable_categories);

        // Initialize buttons properly
        recymats_button = findViewById(R.id.recymats_button);
        junkshop_button = findViewById(R.id.junkshop_button);

        // Enable click events
        recymats_button.setClickable(true);
        junkshop_button.setClickable(true);

        recymats_button.setOnClickListener(v -> {

                Intent intent = new Intent(RecyclableCategories.this, RecyclableMaterials.class);
                startActivity(intent);
        });

        junkshop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclableCategories.this, JunkshopRates.class);
                startActivity(intent);
            }
        });
    }
}
