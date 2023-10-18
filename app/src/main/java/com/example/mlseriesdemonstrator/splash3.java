package com.example.mlseriesdemonstrator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class splash3 extends AppCompatActivity {


    private TextView skip3;
    private TextView next3;
    private TextView prev3;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash3);

        skip3 = findViewById(R.id.skip3);
        next3 = findViewById(R.id.next3);
        prev3 = findViewById(R.id.prev3);

        skip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash3.this,welcome.class);
                startActivity(intent);
            }
        });

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash3.this,welcome.class);
                startActivity(intent);
            }
        });

        prev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash3.this,splash2.class);
                startActivity(intent);
            }
        });

    }
}