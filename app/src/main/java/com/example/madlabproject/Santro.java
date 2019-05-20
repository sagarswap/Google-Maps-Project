package com.example.madlabproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Santro extends AppCompatActivity {
    Button a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_santro);
        b=findViewById(R.id.find);
        a=findViewById(R.id.service);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Adhvait Hyundai Service Centre";
                double lat=12.900664;
                double longi=74.845352;
                Intent i=new Intent(Santro.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Hyundai Showroom";
                double lat=12.901845;
                double longi=74.842016;
                Intent i=new Intent(Santro.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });


    }
}
