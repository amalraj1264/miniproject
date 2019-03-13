package com.example.fueltracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PriceDB extends SQLiteOpenHelper {
    public static final String DBname="Price.db";
    public static final String Tablename="PriceTable";
    public static final String col1="id";
    public static final String col2="petrol";
    public static final String col3="diesel";
    public PriceDB(Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table "+Tablename+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text)";

        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String Query="drop table if exists "+Tablename;
        db.execSQL(Query);
        onCreate(db);

    }
    public boolean insertData(String petrol,String diesel)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,petrol);
        contentValues.put(col3,diesel);

        long status=db.insert(Tablename,null,contentValues);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
