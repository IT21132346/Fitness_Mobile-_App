package com.example.health;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBWorkout extends SQLiteOpenHelper {

    public DBWorkout(Context context) {
        super(context,"Workoutdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase dbWorkout) {
       dbWorkout.execSQL("create table Workoutdetails(workoutName TEXT primary key, workoutRepetitions TEXT, workoutSets TEXT, workoutTime TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbWorkout, int i, int i1) {
        dbWorkout.execSQL("drop table if exists Workoutdetails");
    }

    public  Boolean insertworkoutdata(String workoutName, String workoutRepetitions, String workoutSets, String workoutTime){
        SQLiteDatabase dbWorkout = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("workoutName",workoutName);
        contentValues.put("workoutRepetitions",workoutRepetitions);
        contentValues.put("workoutSets",workoutSets);
        contentValues.put("workoutTime",workoutTime);
        long result = dbWorkout.insert ("Workoutdetails", null, contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public  boolean updateworkoutdata(String workoutName, String workoutRepetitions, String workoutSets, String workoutTime){
        SQLiteDatabase dbWorkout = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("workoutRepetitions",workoutRepetitions);
        contentValues.put("workoutSets",workoutSets);
        contentValues.put("workoutTime",workoutTime);
        Cursor cursor = dbWorkout.rawQuery("select * from Workoutdetails where workoutName = ?",new String[]{workoutName});
        if(cursor.getCount()>0){
            long result = dbWorkout.update("Workoutdetails",contentValues,"workout_name=?", new String[] {workoutName});
            if(result==-1){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }

    public  boolean deleteworkoutdata(String workoutName){
        SQLiteDatabase dbWorkout = this.getWritableDatabase();
        Cursor cursor = dbWorkout.rawQuery("select * from Workoutdetails where workoutName = ?",new String[]{workoutName});
        if(cursor.getCount()>0){
            long result = dbWorkout.delete("Workoutdetails","workoutName=?", new String[] {workoutName});
            if(result==-1){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }

    public  Cursor getdata(){
        SQLiteDatabase dbWorkout = this.getWritableDatabase();
        Cursor cursor = dbWorkout.rawQuery("select * from Workoutdetails",null);
        return cursor;
    }


}
