package com.example.health;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HealthFragment extends Fragment {

    public HealthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_health,container,false);

        // Run
        Button btnAddRem = (Button)view.findViewById(R.id.btn_run);
        btnAddRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), HealthRunActivity.class));
            }
        });

        // Edit MID
        Button btn_editMedID = (Button)view.findViewById(R.id.btn_editMedID);
        btn_editMedID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), HealthEditMedActivity.class));
            }
        });

        // View MID
        Button btn_viewMedID = (Button)view.findViewById(R.id.btn_viewMedID);
        btn_viewMedID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), HealthViewMedActivity.class));
            }
        });

        return view;
    }
}