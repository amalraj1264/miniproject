package com.example.fueltracking;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edit1,edit2;
Button signin,signup;
String uname,password,getpass;
RegisterDB registerDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerDB = new RegisterDB(this);
        registerDB.getWritableDatabase();
        edit1 = (EditText) findViewById(R.id.uname);
        edit2 = (EditText) findViewById(R.id.pass);
        signin = (Button) findViewById(R.id.signinbut);
        signup = (Button) findViewById(R.id.signupbut);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UserRegister.class);
                startActivity(i);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = edit1.getText().toString();
                password = edit2.getText().toString();
                Cursor cur = registerDB.searchdata(uname);
                if(uname.equals("admin")&&(password.equals("admin123")))
                {
                    Intent i = new Intent(getApplicationContext(), AdminActivity.class);
                    startActivity(i);
                }
                else{
                if (cur.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "no name found", Toast.LENGTH_LONG).show();

                } else
                    while (cur.moveToNext()) {
                        getpass = cur.getString(4);
                        if (getpass.equals(password)) {

                            Intent i = new Intent(getApplicationContext(), UserDetails.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "wrong password", Toast.LENGTH_LONG).show();

                        }
                    }


            }}
        });

    }
}
