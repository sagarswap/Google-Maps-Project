package com.example.madlabproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Honda extends AppCompatActivity {
    Button a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honda);
        b=findViewById(R.id.find);
        a=findViewById(R.id.service);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Honda Matrix";
                double lat=12.898206;
                double longi=74.860493;
                Intent i=new Intent(Honda.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Peninsular Honda";
                double lat=12.907061;
                double longi=74.839262;
                Intent i=new Intent(Honda.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });
    }
}
