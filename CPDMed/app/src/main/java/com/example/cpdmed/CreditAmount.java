package com.example.cpdmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreditAmount extends AppCompatActivity {
    private Button newActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_amount);

        newActivityButton =(Button) findViewById(R.id.button10);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openLearningActivity(); }
        });
    }
    public void openLearningActivity(){
        Intent intent = new Intent(this, LaerningOutcome.class);
        startActivity(intent);
    }
}