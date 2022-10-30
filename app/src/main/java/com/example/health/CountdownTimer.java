package com.example.health;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer extends AppCompatActivity {

    Button startstopbutton;
    TextView timertext;
    Timer timer;
    TimerTask timerTask;
    double time = 0.0;
    boolean timerStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_timer);

        timertext =  (TextView) findViewById(R.id.timertext);
        startstopbutton = (Button) findViewById(R.id.startstopbutton);
        timer = new Timer();
    }

    public void resetTapped(View view) {
        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle("Reset Timer");
        resetAlert.setMessage("Are sure you want to reset?");
        resetAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(timerTask!=null){
                    timerTask.cancel();
                    setButtonUi("START", R.color.Sporty_green);
                    time = 0.0;
                    timerStarted = false;
                    timertext.setText(formatTime(0,0,0));
                }
            }
        });

        resetAlert.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //Do nothing
            }
        });
        resetAlert.show();

    }


    //Start Stop Button
    public void startStopTapped(View view) {

        if(timerStarted==false){
            timerStarted = true;
            setButtonUi("STOP", R.color.Red);

            startTimer();
        }
        else{
            timerStarted = false;
            setButtonUi("START", R.color.Sporty_green);

            timerTask.cancel();
        }
    }

    private void setButtonUi(String start, int color) {
        startstopbutton.setText(start);
        startstopbutton.setTextColor(ContextCompat.getColor(this, color));
    }

    private void startTimer()
    {
        timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        time++;
                        timertext.setText(getTimerText());
                    }
                });
            }

        };
        timer.scheduleAtFixedRate(timerTask, 0 ,1000);
    }

    private String getTimerText() {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime( seconds,  minutes,  hours);
    }

    private String formatTime(int second, int minutes, int hours){
        return String.format("%02d",hours)+" : "+String.format("%02d",minutes)+" : "+String.format("%02d",second);
    }
}