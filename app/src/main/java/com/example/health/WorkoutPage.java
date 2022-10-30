package com.example.health;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WorkoutPage extends Fragment {

    Button btnWorkoutPlan,btnBmiCalculator,btnCountdownTimer,btnMusicPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout_page, container, false);


        btnWorkoutPlan = view.findViewById(R.id.btnworkoutplan);
        btnWorkoutPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AddWorkoutPlan.class);
                startActivity(intent);
            }
        });


        btnBmiCalculator = view.findViewById(R.id.btnbmicalculator);
        btnBmiCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),BmiCalculator.class);
                startActivity(intent);
            }
        });
        btnCountdownTimer = view.findViewById(R.id.btncountdowntimer);
        btnCountdownTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CountdownTimer.class);
                startActivity(intent);
            }
        });

//        btnMusicPlayer = view.findViewById(R.id.btnmusicplayer);
//        btnMusicPlayer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),MusicPlsyer.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }

}