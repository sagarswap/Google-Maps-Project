package com.example.madlabproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HindustanMotors extends AppCompatActivity {
    Button a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindustan_motors);
        b=findViewById(R.id.find);
        a=findViewById(R.id.service);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Hindustan Auto Works";
                double lat=12.875807;
                double longi=74.893127;
                Intent i=new Intent(HindustanMotors.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Hindustan Auto Works";
                double lat=12.875807;
                double longi=74.893127;
                Intent i=new Intent(HindustanMotors.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });
    }
}
