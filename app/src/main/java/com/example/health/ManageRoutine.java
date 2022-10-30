package com.example.health;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ManageRoutine extends AppCompatActivity {
    EditText name, description, date , status;
    Button update, delete;
    dbManager DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_row);
        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        description = findViewById(R.id.description);
        status = findViewById(R.id.status);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);

        DB = new dbManager(this);


        Button button = findViewById(R.id.btnUpdate);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(ManageRoutine.this,
                        RoutineAddActivity.class);
                startActivity(intent); // startActivity allow you to move

            }
        });





        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(ManageRoutine.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ManageRoutine.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });


    }}
