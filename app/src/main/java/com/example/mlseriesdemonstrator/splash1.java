package com.example.mlseriesdemonstrator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class splash1 extends AppCompatActivity {

    private TextView skip1;
    private TextView next1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        skip1 = (TextView)findViewById(R.id.skip1);
        next1 = (TextView)findViewById(R.id.next1);

        skip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash1.this,welcome.class);
                startActivity(intent);
            }
        });

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash1.this,splash2.class);
                startActivity(intent);
            }
        });
    }
}