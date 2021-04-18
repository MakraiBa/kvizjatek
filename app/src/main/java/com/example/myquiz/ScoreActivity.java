package com.example.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class ScoreActivity extends AppCompatActivity {
    private TextView score;
    private Button goToList;
    FirebaseFirestore db;
    public String score_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        score = findViewById(R.id.sa_score);
        goToList = findViewById(R.id.goToListbutton);
        db = FirebaseFirestore.getInstance();
        score_str = getIntent().getStringExtra("SCORE");
        score.setText(score_str);
        goToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
                Intent intent = new Intent(ScoreActivity.this, ListActivity.class);
                ScoreActivity.this.startActivity(intent);
                ScoreActivity.this.finish();
            }
        });
    }
    private void uploadData(){
        Map<String, Object> user = new HashMap<>();
        user.put("NAME", MainActivity.username);
        user.put("SCORE", score_str);

        db.collection("USERS")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "Siker: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Hiba!", e);
                    }
                });
    }
}