package com.example.madlabproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUser extends AppCompatActivity {
    Button signup, back;
    DBHelper myDb;
    EditText email, pass, cpass, name, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        signup=findViewById(R.id.signup);
        back=findViewById(R.id.back);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        cpass=findViewById(R.id.cpass);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        myDb=new DBHelper(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regex = "\\d+";
                if(pass.getText().toString().equals(cpass.getText().toString()) &&
                        pass.length()>7 && phone.getText().toString().length()==10 &&
                        phone.getText().toString().matches("[0-9]+") && email.getText().toString().contains("@"))
                {
                    boolean isInserted = myDb.insertData(email.getText().toString(), pass.getText().toString(), phone.getText().toString(), name.getText().toString());
                    if (isInserted)
                        Toast.makeText(AddUser.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(AddUser.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                    finish();
                }
                else if(!email.getText().toString().contains("@"))
                    Toast.makeText(AddUser.this, "Invalid email", Toast.LENGTH_LONG).show();
                else if(pass.length()<8)
                    Toast.makeText(AddUser.this, "Password too short", Toast.LENGTH_LONG).show();
                else if(phone.getText().toString().length()!=10 || !phone.getText().toString().matches("[0-9]+"))
                    Toast.makeText(AddUser.this, "Invalid Phone Number", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddUser.this, "Passwords do not match, Try Again", Toast.LENGTH_LONG).show();
            }
        });
    }
}
