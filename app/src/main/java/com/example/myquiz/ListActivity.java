package com.example.myquiz;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListActivity extends AppCompatActivity {
    Button restartButton;
    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private ListAdapter adapter;
    private List<UserModel> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        restartButton = findViewById(R.id.restart_button);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance();
        usersList = new ArrayList<>();
        adapter = new ListAdapter(this, usersList);
        recyclerView.setAdapter(adapter);
        showData();

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, CategoryActivity.class);
                ListActivity.this.startActivity(intent);
                ListActivity.this.finish();
            }
        });
    }

    private void showData() {
        db.collection("USERS").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        usersList.clear();
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            UserModel model = new UserModel(snapshot.getString("NAME"), snapshot.getString("SCORE"));
                            usersList.add(model);
                        }
                        adapter.notifyDataSetChanged();
                        Collections.sort(usersList, new Sorter());
                        for (int i = usersList.size() - 1; i > 2; i--) {
                            usersList.remove(i);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ListActivity.this, "Hmmm...valami nem stimmel", Toast.LENGTH_SHORT);
            }
        });
    }
}
