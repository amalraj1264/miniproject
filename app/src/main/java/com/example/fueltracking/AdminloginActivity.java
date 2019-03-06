package com.example.fueltracking;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminloginActivity extends AppCompatActivity {
    EditText adminName,adminPass;
    Button adminLogin;
    RegisterDB registerDB;
    String Getpasssword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        registerDB=new RegisterDB(this);
        registerDB.getWritableDatabase();
        adminName=(EditText)findViewById(R.id.adninname);
        adminPass=(EditText)findViewById(R.id.adminpass);
        adminLogin=(Button)findViewById(R.id.adminsignin);
        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String adminname = adminName.getText().toString();
                String password = adminPass.getText().toString();
                Cursor cur = registerDB.searchdata(adminname);
                if (cur.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "no name found", Toast.LENGTH_LONG).show();

                } else
                    while (cur.moveToNext()) {
                         Getpasssword= cur.getString(4);
                        if (Getpasssword.equals(password)) {

                            Intent i = new Intent(getApplicationContext(),AdminActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "wrong password", Toast.LENGTH_LONG).show();

                        }
                    }

            }
        });

    }
}
