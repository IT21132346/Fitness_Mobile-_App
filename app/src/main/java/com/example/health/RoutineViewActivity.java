package com.example.health;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RoutineViewActivity extends AppCompatActivity {


    dbManager DB;
    RecyclerView recyclerView;
    ImageView empty_imageview;
    TextView no_data;
    ArrayList<String> name, date, description,status,title;
    CustomAdapter customAdapter;
    Button delete;
     ItemTouchHelper itemTouchHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routine_view);
        recyclerView = findViewById(R.id.recyclerView);
        delete = findViewById(R.id.btnDelete);


        DB = new dbManager(this);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);




        name = new ArrayList<>();
       date = new ArrayList<>();
        description = new ArrayList<>();
        status = new ArrayList<>();
        title = new ArrayList<>();


        storeDataInArrays();


        customAdapter = new CustomAdapter(RoutineViewActivity.this, this, name, date, description ,status
        );
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RoutineViewActivity.this));

        itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);




        ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(RoutineViewActivity.this,
                        RoutineAddActivity.class);
                intent.putExtra("name",name);
                startActivity(intent); // startActivity allow you to move

            }
        });








    }


    void storeDataInArrays() {
        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0) {
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {

                name.add(cursor.getString(0));
                date.add(cursor.getString(1));
               description.add(cursor.getString(2));
                status.add(cursor.getString(3));

            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }


    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int id ;

            name.remove(viewHolder.getAdapterPosition());
            date.remove(viewHolder.getAdapterPosition());
            description.remove(viewHolder.getAdapterPosition());
            status.remove(viewHolder.getAdapterPosition());





        }
    };






}


