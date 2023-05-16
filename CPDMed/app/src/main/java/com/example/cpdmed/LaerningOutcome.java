package com.example.cpdmed;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class LaerningOutcome extends AppCompatActivity {
    private Button newActivityButton;
    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laerning_outcome);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        editText = (EditText) findViewById(R.id.editTextTextMultiLine2);
        newActivityButton =(Button) findViewById(R.id.button8);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                String outcome = editText.getText().toString();
                Map<String, Object> user = new HashMap<>();
                user.put("outcome", outcome);

                db.collection("users").document(currentUser.getUid()).collection("temp").document("temp")
                        .set(user, SetOptions.merge())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });
                openImpactActivity();
            }
        });
    }
    public void openImpactActivity(){
        Intent intent = new Intent(this, ImpactOnPractice.class);
        startActivity(intent);
    }
}