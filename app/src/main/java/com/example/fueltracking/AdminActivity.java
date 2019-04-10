package com.example.fueltracking;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    EditText PetrolPrice,DieselPrice;
    Button Update,Submit;
    PriceDB priceDB;
    String petrolP,dieselP,getId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        priceDB=new PriceDB(this);
        priceDB.getWritableDatabase();
        PetrolPrice=(EditText)findViewById(R.id.petrolEdit);
        DieselPrice=(EditText)findViewById(R.id.dieselEdit);
        Update=(Button) findViewById(R.id.UpdateBut);
        Submit=(Button)findViewById(R.id.SubmitBut);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petrolP=PetrolPrice.getText().toString();
                dieselP=DieselPrice.getText().toString();
                boolean status=priceDB.insertData(petrolP,dieselP);
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
//        Update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                petrolP=PetrolPrice.getText().toString();
//                dieselP=DieselPrice.getText().toString();
//                boolean status=priceDB.updatedata("1",petrolP,dieselP);
//                if(status==true)
//                {
//                    Toast.makeText(getApplicationContext(),"Successfully Updated",Toast.LENGTH_SHORT).show();
//
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
    }

}
