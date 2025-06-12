package com.appdev.group3.ecollect;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddAnnouncement extends AppCompatActivity {

    private EditText titleField, descriptionField, dateField, startTimeField, endTimeField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_announcement);
/*
        // Initialize views
        titleField = findViewById(R.id.announcementTitleField);
        descriptionField = findViewById(R.id.descriptionField);
        dateField = findViewById(R.id.dateField);
        startTimeField = findViewById(R.id.startTimeField);
        endTimeField = findViewById(R.id.endTimeField);
        Button saveButton = findViewById(R.id.saveButton);
        Button cancelButton = findViewById(R.id.cancelButton);
        ImageButton backButton = findViewById(R.id.backButton);

        // Back button functionality
        backButton.setOnClickListener(v -> onBackPressed());

        // Set date picker for the date field
        dateField.setOnClickListener(v -> showDatePicker());

        // Set time pickers for the start and end time fields
        startTimeField.setOnClickListener(v -> showTimePicker(startTimeField));
        endTimeField.setOnClickListener(v -> showTimePicker(endTimeField));

        // Save button functionality
        saveButton.setOnClickListener(v -> saveAnnouncement());

        // Cancel button functionality
        cancelButton.setOnClickListener(v -> cancelAnnouncement());
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, month1, dayOfMonth) -> dateField.setText((month1 + 1) + "/" + dayOfMonth + "/" + year1),
                year, month, day);
        datePickerDialog.show();
    }

    private void showTimePicker(EditText timeField) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute1) -> {
                    String formattedTime = String.format("%02d:%02d", hourOfDay, minute1);
                    timeField.setText(formattedTime);
                }, hour, minute, false);
        timePickerDialog.show();
    }

    private void saveAnnouncement() {
        String title = titleField.getText().toString().trim();
        String description = descriptionField.getText().toString().trim();
        String date = dateField.getText().toString().trim();
        String startTime = startTimeField.getText().toString().trim();
        String endTime = endTimeField.getText().toString().trim();

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description) ||
                TextUtils.isEmpty(date) || TextUtils.isEmpty(startTime) || TextUtils.isEmpty(endTime)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save announcement logic (e.g., store in database or send to API)
        Toast.makeText(this, "Announcement saved successfully", Toast.LENGTH_SHORT).show();

        // Clear fields after saving
        titleField.setText("");
        descriptionField.setText("");
        dateField.setText("");
        startTimeField.setText("");
        endTimeField.setText("");

        // Optionally finish the activity or navigate back
        finish();
    }

    private void cancelAnnouncement() {
        // Clear all fields
        titleField.setText("");
        descriptionField.setText("");
        dateField.setText("");
        startTimeField.setText("");
        endTimeField.setText("");

        // Optionally navigate back
        finish();
    } */
}
}
