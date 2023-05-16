package com.example.cpdmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    private Button newActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Bottom main menu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        BottomNavigationLogic navigationListener = new BottomNavigationLogic(this, bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(navigationListener);

        // Call customizeMenuColors initially to set the default colors
        navigationListener.changeNavigationLooks(R.id.menu2_reflection);

        // Other code goes here

        newActivityButton =(Button) findViewById(R.id.button6);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openNewActivity(); }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, DateTimeSpent.class);
        startActivity(intent);
    }
}