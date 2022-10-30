package com.example.health;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RoutineAddActivity  extends AppCompatActivity {

    EditText name, date, description,status;
    Button insert;
    dbManager DB;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);

        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        description = findViewById(R.id.description);
        status = findViewById(R.id.status);
        insert = findViewById(R.id.btnInsert);
        status = findViewById(R.id.status);

        // on below line we are initializing our variables.
        date = findViewById(R.id.date);

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
                        RoutineAddActivity.this,
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
        });



        DB = new dbManager(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String dateTXT = date.getText().toString();
                String descriptionTXT =description.getText().toString();
                String statusTXT = status.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, dateTXT,descriptionTXT, statusTXT);
                if(checkinsertdata==true)
                    Toast.makeText(RoutineAddActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(RoutineAddActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();


                Intent i = new Intent(RoutineAddActivity.this,RoutineViewActivity.class);
                startActivity(i);
            }
        });
    }


}
