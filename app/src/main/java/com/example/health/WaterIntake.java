package com.example.health;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WaterIntake  extends AppCompatActivity {


    Button button,button2,button4,button6;
    dbManager DB;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_water_intake);


        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button4 = findViewById(R.id.button4);
        button6 = findViewById(R.id.button6);








        DB = new dbManager(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer value = 50;
                Boolean insert = DB.insertWaterdata(value);
                if(insert==true)
                    Toast.makeText(WaterIntake.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(WaterIntake.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer value = 100;
                Boolean checkinsertdata = DB.insertWaterdata(value);
                if(checkinsertdata==true)
                    Toast.makeText(WaterIntake.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(WaterIntake.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();


            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer value = 150;
                Boolean checkinsertdata = DB.insertWaterdata(value);
                if(checkinsertdata==true)
                    Toast.makeText(WaterIntake.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(WaterIntake.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();


            }
        });

        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
        Calendar c= Calendar.getInstance();
        String date= sdf.format(c.getTime());

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata1();
                if(res.getCount()==0){
                    Toast.makeText(WaterIntake.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Date :"+date+"\n");
                    buffer.append("Intake :"+res.getString(1)+"ml"+"\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(WaterIntake.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }


}
