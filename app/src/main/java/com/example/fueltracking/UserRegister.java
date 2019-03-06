package com.example.fueltracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserRegister extends AppCompatActivity {
    EditText name,mobile,username,password;
    Button Signup,Alreadyreg;
    String strame,strMobile,struname,strpassword;
    RegisterDB registerDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        registerDB=new RegisterDB(this);
        registerDB.getWritableDatabase();
        name=(EditText)findViewById(R.id.editname);
        mobile=(EditText)findViewById(R.id.editmobile);
        username=(EditText)findViewById(R.id.editusername);
        password=(EditText)findViewById(R.id.editpassword);
        Signup=(Button)findViewById(R.id.signupbut);
        Alreadyreg=(Button)findViewById(R.id.alreadyregbut);
        Alreadyreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(a);
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strame=name.getText().toString();
                strMobile=mobile.getText().toString();
                struname=username.getText().toString();
                strpassword=password.getText().toString();


                boolean status=registerDB.insertData(strame,strMobile,struname,strpassword);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"Successfully inserted",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();

                }
            }
        });
        Alreadyreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });



    }
}
