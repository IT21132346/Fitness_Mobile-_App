package com.example.health;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.GnssAntennaInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList name, date, description, status;
    dbManager DB;
    private CustomAdapter adapter;
    private AdapterView.OnItemClickListener listener;

    CustomAdapter(Activity activity, Context context, ArrayList name, ArrayList date, ArrayList description, ArrayList status
    ) {
        this.activity = activity;
        this.context = context;
        this.name = name;
        this.date = date;
        this.description = description;
        this.status = status;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view,listener);

    }




    public  void setOnItemClickListener(AdapterView.OnItemClickListener clickListener){
        listener=clickListener;
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.date_txt.setText(String.valueOf(date.get(position)));
        holder.description_txt.setText(String.valueOf(description.get(position)));
        holder.status_txt.setText(String.valueOf(status.get(position)));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RoutineUpdate.class);
                holder.name_txt.getText().toString();
                context.startActivity(intent);


            }
        });



    }

    @Override
    public int getItemCount() {
        return name.size();
    }




    class MyViewHolder extends RecyclerView.ViewHolder {


        TextView name_txt, date_txt, description_txt, status_txt;
        LinearLayout mainLayout;
        Button button, button1;


        MyViewHolder(@NonNull View itemView, AdapterView.OnItemClickListener listener) {
            super(itemView);
            name_txt = itemView.findViewById(R.id.name_txt);
            date_txt = itemView.findViewById(R.id.date_txt);
            description_txt = itemView.findViewById(R.id.description_txt);
            status_txt = itemView.findViewById(R.id.status_txt);
            context = itemView.getContext();
            button = itemView.findViewById(R.id.btnUpdate);
            button1 = itemView.findViewById(R.id.btnDelete);
            mainLayout = itemView.findViewById(R.id.mainLayout);


        }
    }}












