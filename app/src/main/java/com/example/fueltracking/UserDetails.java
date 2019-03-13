package com.example.fueltracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserDetails extends AppCompatActivity {
    EditText vno,milage,tankcapacity;
    Spinner vtype,ftype;
    Button submit,home;
    String strVno,Vmilage,strtankCapacity,strVtype,strFtype;
    UserDetailsDB userDetailsDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        userDetailsDB=new UserDetailsDB(this);
        userDetailsDB.getWritableDatabase();
        vno=(EditText)findViewById(R.id.VehicleNumber);
        milage=(EditText)findViewById(R.id.vmilage) ;
        tankcapacity=(EditText)findViewById(R.id.capacity);
        vtype=(Spinner)findViewById(R.id.vehicleType);
        ftype=(Spinner)findViewById(R.id.vehicleType);
        submit=(Button)findViewById(R.id.submitbut);
        home=(Button)findViewById(R.id.homebut);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strVno=vno.getText().toString();
                Vmilage=milage.getText().toString();
                strtankCapacity=tankcapacity.getText().toString();
                strVtype=vtype.getSelectedItem().toString();
                strFtype=ftype.getSelectedItem().toString();
                boolean status=userDetailsDB.InsertData(strVno,strVtype,strFtype,Vmilage,strtankCapacity);
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

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
            }
        });

    }
}
