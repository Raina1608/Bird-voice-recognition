package com.example.mlseriesdemonstrator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class splash2 extends AppCompatActivity {

    private TextView skip2;
    private TextView next2;
    private TextView prev2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        skip2 = findViewById(R.id.skip2);
        next2 = findViewById(R.id.next2);
        prev2 = findViewById(R.id.prev2);

        skip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash2.this,welcome.class);
                startActivity(intent);
            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash2.this,splash3.class);
                startActivity(intent);
            }
        });

        prev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash2.this,splash1.class);
                startActivity(intent);
            }
        });

    }
}