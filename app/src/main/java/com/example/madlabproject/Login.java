package com.example.madlabproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class Login extends AppCompatActivity {
    Button login, signup;
    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;
    CheckBox chk;
    EditText username, pass;
    DBHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myDb=new DBHelper(this);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        chk=findViewById(R.id.stay);
        username=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        mPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        mEditor= mPreferences.edit();
        mEditor.putBoolean("loggedin", false);

        if(mPreferences.getBoolean("loggedin", false))
        {
            username.setText(mPreferences.getString("name", ""));
            pass.setText(mPreferences.getString("pass", ""));
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isChecked())
                {
                    mEditor.putBoolean("loggedin", true);
                    mEditor.putString("name", username.getText().toString());
                    mEditor.putString("pass", pass.getText().toString());
                    mEditor.commit();
                }
                String naaam="";
                Cursor res=myDb.getData();
                String buffer[]=new String[100];
                int cnt=0;
                boolean chk1=false;
                if(res.getCount()==0)
                    Toast.makeText(Login.this, "User Not Present", Toast.LENGTH_LONG).show();
                while(res.moveToNext())
                {
                    buffer[cnt]=(res.getString(0)+"\t"+res.getString(1)+"\t"+
                            res.getString(2)+"\t"+res.getString(3)+"\t"+
                            res.getString(4)+"\n");
                    if (buffer[cnt].toString().contains(username.getText().toString()) &&
                            buffer[cnt].toString().contains(pass.getText().toString()) &&
                            username.getText().toString().length()>0)
                        chk1 = true;
                    cnt++;
                }
                int loc=username.getText().toString().indexOf("@");
                if(loc!=-1)
                    naaam=username.getText().toString().substring(0, loc);
                if(chk1)
                {
                    Intent intent=new Intent(Login.this, Home.class);
                    intent.putExtra("username", naaam);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(Login.this, "Username or Password is incorrect", Toast.LENGTH_LONG).show();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this, AddUser.class);
                startActivity(i);
            }
        });
    }

    private void checkPreferences()
    {
        boolean chkbox=mPreferences.getBoolean("loggedin", false);
        String name=mPreferences.getString("name", "");
        String pass=mPreferences.getString("pass", "");
    }
}
