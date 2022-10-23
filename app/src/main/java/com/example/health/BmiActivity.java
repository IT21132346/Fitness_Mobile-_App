package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.HttpCookie;

public class BmiActivity extends AppCompatActivity {

    Button reCalculateBmi;
    TextView BmiDisplay,GenderDisplay,BmiCategoryDispaly;
    ImageView BmiImage;
    String Bmi;
    float floatBmi;
    String height;
    String weight;
    float floatHeight,floatWeight;
    RelativeLayout mBackground;

    //@SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

//        getSupportActionBar().setElevation(0);
//        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
//        getSupportActionBar().setTitle("Result");
//        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
//        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        Intent intent = getIntent();

        BmiDisplay = findViewById(R.id.bmidisplay);
        BmiCategoryDispaly = findViewById(R.id.bmicategorydispaly);
        GenderDisplay = findViewById(R.id.genderdisplay);
        mBackground = findViewById(R.id.contentlayout);
        BmiImage = findViewById(R.id.bmiimage);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        floatHeight=Float.parseFloat(height);
        floatWeight=Float.parseFloat(weight);

        floatHeight=floatHeight/100;
        floatBmi = floatWeight / (floatHeight*floatHeight);

        Bmi = Float.toString(floatBmi);


        if(floatBmi<16){
            BmiCategoryDispaly.setText("Severe Thinness");
            mBackground.setBackgroundColor(Color.RED);
            BmiImage.setImageResource(R.drawable.crosss);
        }
       else if(floatBmi<16.9 && floatBmi>16){
            BmiCategoryDispaly.setText("Moderate Thinnest");
            mBackground.setBackgroundColor(Color.RED);
            BmiImage.setImageResource((R.drawable.warning));
        }
        else if(floatBmi<18.4 && floatBmi>17){
            BmiCategoryDispaly.setText("Mild Thinnest");
            mBackground.setBackgroundColor(Color.RED);
            BmiImage.setImageResource((R.drawable.warning));
        }
        else if(floatBmi<25 && floatBmi>18.4){
            BmiCategoryDispaly.setText("Normal");
            //mBackground.setBackgroundColor(Color.YELLOW);
            BmiImage.setImageResource((R.drawable.ok));
        }
        else if(floatBmi<29.4 && floatBmi>25){
            BmiCategoryDispaly.setText("Over Weight");
            mBackground.setBackgroundColor(Color.RED);
            BmiImage.setImageResource((R.drawable.warning));
        }
        else{
            BmiCategoryDispaly.setText("Obese ");
            mBackground.setBackgroundColor(Color.RED);
            BmiImage.setImageResource((R.drawable.warning));
        }

        GenderDisplay.setText(intent.getStringExtra("gender"));
        BmiDisplay.setText(Bmi);






        reCalculateBmi = findViewById(R.id.recalculatyourbmi);
        reCalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BmiActivity.this,BmiCalculator.class);
                startActivity(intent);
                finish();
            }
        });

    }
}