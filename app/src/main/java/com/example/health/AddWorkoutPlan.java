package com.example.health;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddWorkoutPlan extends AppCompatActivity {

    EditText Workout_Name,Workout_Repetition,Workout_Sets,Workout_Time;
    Button btn_Workout_Submit,btn_Workout_Update,btn_Workout_View,btn_Workout_Delete;
    DBWorkout dbWorkout;
    ImageView img_backtoworkoutPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout_plan);

        Workout_Name = (EditText) findViewById(R.id.workout_name);
        Workout_Repetition =(EditText) findViewById(R.id.workout_repetition);
        Workout_Sets =(EditText) findViewById(R.id.workout_sets);
        Workout_Time =(EditText) findViewById(R.id.workout_time);

        btn_Workout_Submit =(Button) findViewById(R.id.btn_workout_submit);
        btn_Workout_Update = (Button)findViewById(R.id.btn_workout_update);
        btn_Workout_View = (Button)findViewById(R.id.btn_workout_view);
        btn_Workout_Delete = (Button)findViewById(R.id.btn_workout_delete);

        dbWorkout = new DBWorkout(this);

        btn_Workout_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String workoutNameTXT = Workout_Name.getText().toString();
                String workoutRepetitionsTXT = Workout_Repetition.getText().toString();
                String workoutSetsTXT = Workout_Sets.getText().toString();
                String workoutTimeTXT = Workout_Time.getText().toString();


                Boolean checkinsertdata = dbWorkout. insertworkoutdata(workoutNameTXT, workoutRepetitionsTXT, workoutSetsTXT, workoutTimeTXT);
                if(checkinsertdata==true){
                    Toast.makeText(AddWorkoutPlan.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AddWorkoutPlan.this, "Invalid Data", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //storing edited data
        btn_Workout_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String workoutNameTXT = Workout_Name.getText().toString();
                String workoutRepetitionsTXT = Workout_Repetition.getText().toString();
                String workoutSetsTXT = Workout_Sets.getText().toString();
                String workoutTimeTXT = Workout_Time.getText().toString();

                Boolean checkupdatedata = dbWorkout.updateworkoutdata(workoutNameTXT,workoutRepetitionsTXT,workoutSetsTXT,workoutTimeTXT);
                if(checkupdatedata==true){
                    Toast.makeText(AddWorkoutPlan.this,"Data Updated Successfully",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AddWorkoutPlan.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_Workout_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String workoutNameTXT = Workout_Name.getText().toString();

                Boolean checkdeletedata = dbWorkout.deleteworkoutdata(workoutNameTXT);
                if(checkdeletedata==true)
                    Toast.makeText(AddWorkoutPlan.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddWorkoutPlan.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });

        btn_Workout_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = dbWorkout.getdata();
                if(cursor.getCount()==0){
                    Toast.makeText(AddWorkoutPlan.this, "No Entry Exist", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()){
                    buffer.append("Workout Name: "+cursor.getString(0)+"\n");
                    buffer.append("Repetitions: "+cursor.getString(1)+"\n");
                    buffer.append("Sets: "+cursor.getString(2)+"\n");
                    buffer.append("Time: "+cursor.getString(3)+"\n");
                    buffer.append("\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(AddWorkoutPlan.this);
                builder.setCancelable(true);
                builder.setTitle("Workout Details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}