package com.example.health;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Blob;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE MedDetails(name TEXT primary key, allergies TEXT, medConditions TEXT, dob TEXT, image BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE if Exists MedDetails");
    }

    public Boolean insertUserData(String name, String dob, String allergies, String medConditions){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("dob", dob);
        contentValues.put("allergies", allergies);
        contentValues.put("medConditions", medConditions);
//        contentValues.put("image", image);
        long result = DB.insert("MedDetails", null, contentValues);
        if (result == -1){
            return false;
        }
        else return true;
    }

    public Boolean updateUserData(String name, String dob, String allergies, String medConditions){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dob", dob);
        contentValues.put("allergies", allergies);
        contentValues.put("medConditions", medConditions);
//        contentValues.put("image", image);
        Cursor cursor = DB.rawQuery("SELECT * FROM MedDetails WHERE name = ?", new String[] {name});
        if (cursor.getCount() > 0) {
            long result = DB.update("MedDetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else return true;
        }
        else return false;
    }

    public Boolean deleteUserData(String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM MedDetails WHERE name = ?", new String[] {name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("MedDetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else return true;
        }
        else return false;
    }

    public Cursor getUserData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("SELECT * FROM MedDetails " ,null);
    }
}
