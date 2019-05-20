package com.example.madlabproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Volkswagen extends AppCompatActivity {
    Button a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volkswagen);
        b=findViewById(R.id.find);
        a=findViewById(R.id.service);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Volkswagon Bharat Vehicle Works";
                double lat=13.368901;
                double longi=74.747463;
                Intent i=new Intent(Volkswagen.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Volkswagon Bharat Vehicle Works";
                double lat=13.368810;
                double longi=74.747419;
                Intent i=new Intent(Volkswagen.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });
    }
}
