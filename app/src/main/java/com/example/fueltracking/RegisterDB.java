package com.example.fueltracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegisterDB extends SQLiteOpenHelper {
    public static final String DBname="Register.db";
    public static final String Tablename="UserReg";
    public static final String col1="id";
    public static final String col2="name";
    public static final String col3="mobile";
    public static final String col4="username";
    public static final String col5="password";

    public RegisterDB(Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Query="create table "+Tablename+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text)";

        db.execSQL(Query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String Query="drop table if exists "+Tablename;
        db.execSQL(Query);
        onCreate(db);

    }

    public boolean insertData(String name,String mob,String username,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,mob);
        contentValues.put(col4,username);
        contentValues.put(col5,password);

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
    public Cursor searchdata(String username)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cur=db.rawQuery("SELECT * FROM "+Tablename+" WHERE "+col4+"='"+username+"'",null);
        return cur;
    }


}
