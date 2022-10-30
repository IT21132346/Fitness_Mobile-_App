package com.example.health;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {




    CardView cardView1,cardView3,cardView4,cardView2,cardView5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home,container,false);


        cardView1=view.findViewById(R.id.cardView1);
        cardView1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new fragment_meal());
                fr.commit();
            }
        });




        cardView2=view.findViewById(R.id.cardView2);
        cardView2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new WorkoutPage());
                fr.commit();
            }
        });

        cardView3=view.findViewById(R.id.cardView3);
        cardView3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new HealthFragment());
                fr.commit();
            }
        });
        cardView4=view.findViewById(R.id.cardView4);
        cardView4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new RoutineFragment());
                fr.commit();
            }
        });

        cardView5=view.findViewById(R.id.cardView5);
        cardView5.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), HealthRunActivity.class));
            }
        });

        return view;
    }

}