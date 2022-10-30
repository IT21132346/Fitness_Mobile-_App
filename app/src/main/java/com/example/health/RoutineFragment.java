package com.example.health;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RoutineFragment extends Fragment {
    Button button1,button2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_routine,container,false);

         button1 = (Button)view.findViewById(R.id.btn_viewMedID);
         button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ReminderActivity.class));
            }
        });

        button2 = (Button)view.findViewById(R.id.btn_run);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RoutineViewActivity.class));
            }
        });




        return view;


    }
}