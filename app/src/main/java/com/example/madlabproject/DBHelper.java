package com.example.madlabproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Contacts.db";
    public static final String TABLE_NAME="contact_table";
    public static final String COL_1="ID";
    public static final String COL_2="Email";
    public static final String COL_3="Password";
    public static final String COL_4="Phone";
    public static final String COL_5="Name";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, PASSWORD TEXT, PHONE TEXT, NAME TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String mail, String pass, String ph, String nam) //Inserts DB Entires
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_2,mail);
        cv.put(COL_3, pass);
        cv.put(COL_4, ph);
        cv.put(COL_5, nam);
        long r=db.insert(TABLE_NAME, null, cv);
        if(r==-1)
            return false;
        else
            return true;
    }
    public Cursor getData() //Shows DB Result
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+ TABLE_NAME , null);
        return res;
    }
    public boolean updateData(String id, String mail, String pass, String ph, String nam)    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_1,id);
        cv.put(COL_2,mail);
        cv.put(COL_3, pass);
        cv.put(COL_4, ph);
        cv.put(COL_5, nam);
        db.update(TABLE_NAME,cv, "ID = ?", new String[] {id});
        return true;
    }
}

