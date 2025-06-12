package com.appdev.group3.ecollect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_profile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        // Announcement Button
        ImageButton announcementBtn = findViewById(R.id.announce_btn);
        announcementBtn.setOnClickListener(v -> navigateToMainActivity1());

        // Log Out Button
        ImageButton logOutButton = findViewById(R.id.signout_btn);
        logOutButton.setOnClickListener(v -> logOutAdminProfile());
    }

    private void navigateToMainActivity1() {
        Intent intent = new Intent(AdminProfile.this, MainActivity1.class);
        startActivity(intent);
    }

    private void logOutAdminProfile() {
        Intent intent = new Intent(AdminProfile.this, LogInAdmin.class);
        startActivity(intent);
    }
}