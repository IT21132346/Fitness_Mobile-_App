package com.example.health;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class RoutineUpdate extends AppCompatActivity {
    EditText name, description, date , status;
    Button update;
    dbManager DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_routine);
        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        description = findViewById(R.id.description);
        update = findViewById(R.id.update);
        status = findViewById(R.id.status);
        DB = new dbManager(this);
        // on below line we are initializing our variables.
        date = findViewById(R.id.date);


        Intent i = getIntent();

        ArrayList<String> t1 = i.getStringArrayListExtra("name");
        ArrayList<String> t2 = i.getStringArrayListExtra("date");
        ArrayList<String> t3 = i.getStringArrayListExtra("description");
        ArrayList<String> t4 = i.getStringArrayListExtra("status");




        // on below line we are adding click listener
        // for our pick date button
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        RoutineUpdate.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        }
        );





        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String dateTXT = date.getText().toString();
                String descriptionTXT = description.getText().toString();
                String statusTXT = status.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, dateTXT, descriptionTXT,statusTXT);
                if(checkupdatedata==true)
                    Toast.makeText(RoutineUpdate.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(RoutineUpdate.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();

                name.setText("");
                date.setText("");
                description.setText("");
                status.setText("");
                name.requestFocus();



            }          }
        );





    }}

