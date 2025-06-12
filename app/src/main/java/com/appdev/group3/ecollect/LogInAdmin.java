package com.appdev.group3.ecollect;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogInAdmin extends AppCompatActivity {

    private EditText loginAdminEmail, loginAdminPassword;
    private Button adminLogIn, btn_register;

    private final String hardcodedEmail = "admin@gmail.com";
    private final String hardcodedPassword = "onlyAdminPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in_admin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginAdminEmail = findViewById(R.id.admin_email);
        loginAdminPassword = findViewById(R.id.admin_password);
        adminLogIn = findViewById(R.id.btn_login_admin);

        adminLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginAdminEmail.getText().toString().trim();
                String pass = loginAdminPassword.getText().toString().trim();

                boolean valid = true;

                if (email.isEmpty()) {
                    loginAdminEmail.setError("Email cannot be empty");
                    loginAdminEmail.requestFocus();
                    valid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    loginAdminEmail.setError("Please enter a valid email address");
                    loginAdminEmail.requestFocus();
                    valid = false;
                }

                if (pass.isEmpty()) {
                    loginAdminPassword.setError("Password cannot be empty");
                    loginAdminPassword.requestFocus();
                    valid = false;
                }

                if (valid) {
                    if (email.equals(hardcodedEmail) && pass.equals(hardcodedPassword)) {
                        Intent intent = new Intent(LogInAdmin.this, AdminProfile.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LogInAdmin.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        findViewById(R.id.btn_register).setOnClickListener(v -> {
            Intent intent = new Intent(LogInAdmin.this, UserRegister.class);
            startActivity(intent);
        });
    }
}