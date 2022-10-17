package com.example.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.health.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MealFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.home_nav:
                    replaceFragment(new HealthRunFragment());
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
                    replaceFragment(new HealthRunFragment());
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