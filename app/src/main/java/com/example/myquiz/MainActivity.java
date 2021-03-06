package com.example.myquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
    private TextView title;
    private Button start;
    public static String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.main_title);
        start = findViewById(R.id.ma_startB);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.fashion_fetish_bold);
        title.setTypeface(typeface);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameField = (EditText) findViewById(R.id.user_input);
                username = usernameField.getText().toString();
                if (username.length() == 0) {
                    usernameField.setError("Minden adatot adj meg!");
                } else {
                    Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}