package com.example.cpdmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DateTimeSpent extends AppCompatActivity {
    private Button newActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_spent);

        newActivityButton =(Button) findViewById(R.id.button3);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openNameActivity(); }
        });
    }
    public void openNameActivity(){
        Intent intent = new Intent(this, NameOfActivity.class);
        startActivity(intent);
    }
}