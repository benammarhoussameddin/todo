package com.codegama.todolistapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBsqlite extends SQLiteOpenHelper {
    public  static  final String DBname="data.db";
    public DBsqlite(@Nullable Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table signup(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT ,password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS signup");
    onCreate(db);
    }

    public boolean insertData(String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=db.insert("signup",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }

    }
    public boolean checkusers(String username,String password,Context context){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from signup",null);
        res.moveToFirst();
        int a=0;
        while(res.isAfterLast()==false){
            String t1=res.getString(1),t2=res.getString(2);
            if(t1.equals(username)&&t2.equals(password)){
                a=1;
                break;
            }else{
                res.moveToNext();
            }

        }
        if (a==1){
            return true;
        }else{
            return false;
        }
    }
}
