package com.example.cpdmed;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Attachments extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attachments);

        // Bottom main menu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        BottomNavigationLogic navigationListener = new BottomNavigationLogic(this, bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(navigationListener);

        // Call customizeMenuColors initially to set the default colors
        navigationListener.changeNavigationLooks(R.id.menu3_attachments);

        // Other code goes here
    }

}
