package com.example.madlabproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ford extends AppCompatActivity {
    Button b, a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ford);
        b=findViewById(R.id.find);
        a=findViewById(R.id.service);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Cauvery Ford";
                double lat=13.328745;
                double longi=74.738195;
                Intent i=new Intent(Ford.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="Cauvery Ford";
                double lat=13.328745;
                double longi=74.738195;
                Intent i=new Intent(Ford.this, MapsActivity.class);
                i.putExtra("name", str);
                i.putExtra("lat", lat);
                i.putExtra("longi", longi);
                startActivity(i);
            }
        });

    }
}
