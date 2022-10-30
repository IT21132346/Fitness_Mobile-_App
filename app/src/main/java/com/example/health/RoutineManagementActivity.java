package com.example.health;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RoutineManagementActivity extends AppCompatActivity {
    EditText name, description, date , status;
    Button insert, update, delete, view;
    dbManager DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routine_management);
        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        description = findViewById(R.id.description);
        status = findViewById(R.id.status);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new dbManager(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String dateTXT = date.getText().toString();
                String descriptionTXT = description.getText().toString();
                String statusTXT = status.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, dateTXT, descriptionTXT,statusTXT);
                if(checkinsertdata==true)
                    Toast.makeText(RoutineManagementActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(RoutineManagementActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });


        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String dateTXT = date.getText().toString();
                String descriptionTXT = description.getText().toString();
                String statusTXT = status.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, dateTXT, descriptionTXT,statusTXT);
                if(checkupdatedata==true)
                    Toast.makeText(RoutineManagementActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(RoutineManagementActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(RoutineManagementActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(RoutineManagementActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });


    }}
