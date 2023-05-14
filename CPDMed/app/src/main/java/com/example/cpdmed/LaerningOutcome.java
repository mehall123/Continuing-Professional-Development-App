package com.example.cpdmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaerningOutcome extends AppCompatActivity {
    private Button newActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laerning_outcome);

        newActivityButton =(Button) findViewById(R.id.button8);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openImpactActivity(); }
        });
    }
    public void openImpactActivity(){
        Intent intent = new Intent(this, ImpactOnPractice.class);
        startActivity(intent);
    }
}