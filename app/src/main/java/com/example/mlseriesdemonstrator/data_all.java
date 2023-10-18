package com.example.mlseriesdemonstrator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class data_all extends AppCompatActivity {

    private TextView descr_rec , text_rec;
    private ImageView imageview_rec;
    private Button more_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_all);

        descr_rec = findViewById(R.id.descr_rec);
        text_rec = findViewById(R.id.text_rec);
        imageview_rec = findViewById(R.id.imageview_rec);
        more_info = findViewById(R.id.more_info);

        text_rec.setText(getIntent().getExtras().getString("Title"));
        descr_rec.setText(getIntent().getExtras().getString("Des"));

        int image_my = getIntent().getIntExtra("image",0);
        imageview_rec.setImageResource(image_my);


        more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://ebird.org/home";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });



    }
}