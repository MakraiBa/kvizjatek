package com.example.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class LevelActivity extends AppCompatActivity {

    private Button easyButton;
    private Button hardButton;
    public static int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        easyButton = findViewById(R.id.beginner_button);
        hardButton = findViewById(R.id.pro_button);

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = 1;
                goToQuestions();
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = 2;
                goToQuestions();
            }
        });
    }

    public void goToQuestions() {
        Intent intent = new Intent(LevelActivity.this, QuestionActivity.class);
        startActivity(intent);
    }
}

