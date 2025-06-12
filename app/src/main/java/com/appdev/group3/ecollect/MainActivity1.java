package com.appdev.group3.ecollect;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {
    EditText announcement_msg;
    Button insert, view, delete;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        // Initialize the views using their IDs
        announcement_msg = findViewById(R.id.announcement_msg);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);

        // Initialize the database helper
        DB = new DBHelper(this);

        // Set onClickListener for the view button
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity1.this, Userlist.class));
            }
        });

        // Set onClickListener for the insert button
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgTXT = announcement_msg.getText().toString().trim();

                if (msgTXT.isEmpty()) {
                    Toast.makeText(MainActivity1.this, "Message is empty", Toast.LENGTH_SHORT).show();
                    Log.e("INPUT_ERROR", "No message entered");
                    return;
                }

                Boolean checkinsertdata = DB.insertuserdata(msgTXT);

                if (checkinsertdata) {
                    Toast.makeText(MainActivity1.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity1.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set onClickListener for the delete button
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = announcement_msg.getText().toString();

                Boolean checkdeletedata = DB.deleteuserdata(nameTXT);
                if (checkdeletedata) {
                    Toast.makeText(MainActivity1.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity1.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}