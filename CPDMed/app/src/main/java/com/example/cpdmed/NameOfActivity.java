package com.example.cpdmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NameOfActivity extends AppCompatActivity {
    private Button newActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_of);

        newActivityButton =(Button) findViewById(R.id.button7);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openCreditActivity(); }
        });
    }
    public void openCreditActivity(){
        Intent intent = new Intent(this, CreditAmount.class);
        startActivity(intent);
    }
}