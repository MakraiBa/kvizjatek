package com.example.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {
    private Button carButton;
    private Button historyButton;
    private Button ITButton;
    private Button famousButton;
    private Button capitalButton;
    public static int selectedCategory = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        carButton = findViewById(R.id.car_button);
        historyButton = findViewById(R.id.history_button);
        ITButton = findViewById(R.id.IT_button);
        famousButton = findViewById(R.id.famous_button);
        capitalButton = findViewById(R.id.capital_button);

        famousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = 1;
                goToLevels();
            }
        });
        capitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = 2;
                goToLevels();
            }
        });

        carButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = 3;
                goToLevels();
            }
        });

        ITButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = 4;
                goToLevels();
            }
        });
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = 5;
                goToLevels();
            }
        });
    }

    public void goToLevels() {
        Intent intent = new Intent(CategoryActivity.this, LevelActivity.class);
        startActivity(intent);
    }

}

