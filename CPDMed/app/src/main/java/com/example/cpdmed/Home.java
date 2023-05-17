package com.example.cpdmed;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.MotionEffect;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Home extends AppCompatActivity {

    private Button newActivityButton;
    private Button totalCreditsButton;
    private Button totalExternalCreditsButton;
    private Button totalInternalCreditsButton;
    private Button totalPersonalCreditsButton;
    private Integer totalCredits = 0;
    private Integer totalExternalCredits = 0;
    private Integer totalInternalCredits = 0;
    private Integer totalPersonalCredits = 0;
    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
       totalCreditsButton = (Button) findViewById(R.id.button);
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        db.collection("users").document(currentUser.getUid()).collection("credits").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {

                        totalCredits += document.getLong("credit").intValue();
                    }
                    totalCreditsButton.setText(totalCredits + " Credits");
                    Log.d(MotionEffect.TAG, "Success");
                } else {
                    Log.d(MotionEffect.TAG, "Error getting documents: ", task.getException());
                }
            }
        });
        totalExternalCreditsButton = (Button) findViewById(R.id.button2);
        db.collection("users").document(currentUser.getUid()).collection("credits").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if(Objects.equals(document.getString("type"), "External")) {
                            totalExternalCredits += document.getLong("credit").intValue();
                        }
                    }
                    totalExternalCreditsButton.setText(totalExternalCredits + " External Credits");
                    Log.d(MotionEffect.TAG, "Success");
                } else {
                    Log.d(MotionEffect.TAG, "Error getting documents: ", task.getException());
                }
            }
        });
        totalInternalCreditsButton = (Button) findViewById(R.id.button4);
        db.collection("users").document(currentUser.getUid()).collection("credits").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if(Objects.equals(document.getString("type"), "Internal")) {
                            totalInternalCredits += document.getLong("credit").intValue();
                        }
                    }
                    totalInternalCreditsButton.setText(totalInternalCredits + " Internal Credits");
                    Log.d(MotionEffect.TAG, "Success");
                } else {
                    Log.d(MotionEffect.TAG, "Error getting documents: ", task.getException());
                }
            }
        });
        totalPersonalCreditsButton = (Button) findViewById(R.id.button5);
        db.collection("users").document(currentUser.getUid()).collection("credits").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if(Objects.equals(document.getString("type"), "Personal")) {
                            totalPersonalCredits += document.getLong("credit").intValue();
                        }
                    }
                    totalPersonalCreditsButton.setText(totalPersonalCredits + " Personal Credits");
                    Log.d(MotionEffect.TAG, "Success");
                } else {
                    Log.d(MotionEffect.TAG, "Error getting documents: ", task.getException());
                }
            }
        });
        newActivityButton =(Button) findViewById(R.id.button6);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                db.collection("users").document(currentUser.getUid()).collection("temp").document("temp").delete();
                openNewActivity();
            }
        });
        totalCreditsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTotalCreditsActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, ExternalInternalPersonal.class);
        startActivity(intent);
    }
    public void openTotalCreditsActivity(){
        //Intent intent = new Intent(this, TotalCreditsActivity.class);
        //startActivity(intent);
    }
}