package com.example.fueltracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDetailsDB extends SQLiteOpenHelper {
    public static final String DBname="UserDetails.db";
    public static final String Tablename="userdetails";
    public static final String col1="id";
    public static final String col2="Vno";
    public static final String col3="Vtype";
    public static final String col4="fuelType";
    public static final String col5="milage";
    public static final String col6="tankCap";

    public UserDetailsDB(Context context) {

        super(context, DBname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table "+Tablename+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text,"+col6+" text)";

        db.execSQL(Query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String Query="drop table if exists "+Tablename;
        db.execSQL(Query);
        onCreate(db);

    }
    public boolean InsertData(String vno,String vtype,String fuel,String milage,String capacity)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,vno);
        contentValues.put(col3,vtype);
        contentValues.put(col4,fuel);
        contentValues.put(col5,milage);
        contentValues.put(col6,capacity);

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
