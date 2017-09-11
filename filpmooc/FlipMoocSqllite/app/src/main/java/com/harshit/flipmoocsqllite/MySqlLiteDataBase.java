package com.harshit.flipmoocsqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 05-04-2017.
 */

public class MySqlLiteDataBase extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="statofsaving.db";
    public static final String TABLE_NAME="savings_table";
    public static final String namecol="NAME";
    public static final String expense="EXPENDITURE";
    public static final String savings="SAVINGS";


    public MySqlLiteDataBase(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table "+TABLE_NAME+"(NAME TEXT ,EXPENDITURE INTEGER,SAVINGS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }
    public boolean addintotable(String name,String xexp,String saving)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues tabledata=new ContentValues();
        tabledata.put(namecol,name);
        tabledata.put(expense,xexp);
        tabledata.put(savings,saving);
        long res=db.insert(TABLE_NAME,null,tabledata);
        if(res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("select * from "+TABLE_NAME,null);
        return data;
    }

}
