package com.example.madlabproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent myintent=getIntent();
        Bundle b=myintent.getExtras();
        txt=findViewById(R.id.welcome);
        txt.setText("Welcome "+b.get("username").toString());
        ListView lv=findViewById(R.id.listvehicle);
        List<String> vehicles = new ArrayList<String>();
        vehicles.add("Hyndai");
        vehicles.add("Ford Figo");
        vehicles.add("Honda");
        vehicles.add("Hindustan Motors");
        vehicles.add("Toyota");
        vehicles.add("Tata");
        vehicles.add("Volkswagen");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                vehicles );

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if(position==0)
                {
                    Intent i=new Intent(Home.this, Santro.class);
                    startActivity(i);
                }
                else if(position==1)
                {
                    Intent i=new Intent(Home.this, Ford.class);
                    startActivity(i);
                }
                else if(position==2)
                {
                    Intent i=new Intent(Home.this, Honda.class);
                    startActivity(i);
                }
                else if(position==3)
                {
                    Intent i=new Intent(Home.this, HindustanMotors.class);
                    startActivity(i);
                }
                else if(position==4)
                {
                    Intent i=new Intent(Home.this, Toyota.class);
                    startActivity(i);
                }

                else if(position==5)
                {
                    Intent i=new Intent(Home.this, Tata.class);
                    startActivity(i);
                }
                else if(position==6)
                {
                    Intent i=new Intent(Home.this, Volkswagen.class);
                    startActivity(i);
                }




            }
        });
    }
}
