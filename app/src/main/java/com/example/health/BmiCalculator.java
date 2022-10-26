package com.example.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class BmiCalculator extends AppCompatActivity {

    Button CalculateYourBmi;

    TextView CurrentHeight,CurrentAge,CurrentWeight;
    ImageView MinusWeight,PlusWeight,MinusAge,PlusAge;
    SeekBar SeekbarHeight;
    ConstraintLayout Male,Female;

    int int_Weight =50;
    int int_age=23;
    int current_progress;
    String mint_progress="170";
    String typeof_user="0";
    String weight2="50";
    String age2="23";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);


        CalculateYourBmi = findViewById(R.id.calculatyourbmi);
        CurrentAge = findViewById(R.id.currentage);
        CurrentHeight = findViewById(R.id.currentheight);
        CurrentWeight = findViewById(R.id.currentweight);
        MinusWeight = findViewById(R.id.minusweight);
        PlusWeight = findViewById(R.id.plusweight);
        MinusAge = findViewById(R.id.minusage);
        PlusAge = findViewById(R.id.plusage);
        SeekbarHeight = findViewById(R.id.seekbarheight);
        Male = findViewById(R.id.male);
        Female = findViewById(R.id.female);


        //Clicking MALE/FEMALE button
        Male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                Female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_notfocus));
                typeof_user = "Male";
            }
        });

        Female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                Male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_notfocus));
                typeof_user = "Female";
            }
        });
        //------------------------------------------------------------------------------------------
        //Seek Bar segment
        SeekbarHeight.setMax(300);
        SeekbarHeight.setProgress(100);
        SeekbarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                current_progress = i;
                mint_progress = String.valueOf(current_progress);
                CurrentHeight.setText(mint_progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //------------------------------------------------------------------------------------------

        //Increase the AGE & WEIGHT values
        PlusAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int_age = int_age+1;
                age2 = String.valueOf(int_age);
                CurrentAge.setText(age2);
            }
        });

        PlusWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int_Weight = int_Weight+1;
                weight2 = String.valueOf(int_Weight);
                CurrentWeight.setText(weight2);
            }
        });
        //------------------------------------------------------------------------------------------

        //Decrease the AGE & WEIGHT values
        MinusAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int_age = int_age-1;
                age2 = String.valueOf(int_age);
                CurrentAge.setText(age2);
            }
        });

        MinusWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int_Weight = int_Weight-1;
                weight2 = String.valueOf(int_Weight);
                CurrentWeight.setText(weight2);
            }
        });

        //Calculate the BMI
        CalculateYourBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(typeof_user.equals("0")){
                    Toast.makeText(BmiCalculator.this, "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }
                else if(mint_progress.equals("0")){
                    Toast.makeText(BmiCalculator.this, "Select Your Height First", Toast.LENGTH_SHORT).show();
                }
                else if(int_age<=0){
                    Toast.makeText(BmiCalculator.this, "Invalid Age", Toast.LENGTH_SHORT).show();
                }
                else if(int_Weight<=0){
                    Toast.makeText(BmiCalculator.this, "Invalid Weight", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(BmiCalculator.this, BmiActivity.class);

                    intent.putExtra("gender",typeof_user);
                    intent.putExtra("height",mint_progress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);

                    startActivity(intent);
                    finish();
                }

            }
        });
        //------------------------------------------------------------------------------------------
    }
}