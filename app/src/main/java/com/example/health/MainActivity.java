package com.example.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.health.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;





public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.home_nav:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.meals_nav:
                    replaceFragment(new MealFragment());
                    break ;
                case R.id.health_nav:
                    replaceFragment(new HealthFragment());
                    break;
                case R.id.workout_nav:
                    replaceFragment(new HealthRunFragment());
                    break;
                case R.id.routines_nav:
                    replaceFragment(new RoutineFragment());
                    break;

            }
            return true;
        });
    }
  private void replaceFragment(Fragment fragment){
      FragmentManager fragmentManager = getSupportFragmentManager();
      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      fragmentTransaction.replace(R.id.frame_layout, fragment);
      fragmentTransaction.commit();
  }












}
