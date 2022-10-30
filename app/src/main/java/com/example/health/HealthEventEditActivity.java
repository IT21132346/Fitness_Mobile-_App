package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalTime;

public class HealthEventEditActivity extends AppCompatActivity {

    private EditText eventName;
    private TextView eventDateView, eventTime;

    private LocalTime time;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_event_edit);
        intWidgets();
        time = LocalTime.now();
        eventDateView.setText("Date : " + CalendarUtil.formattedDate(CalendarUtil.selectedDate));
        eventTime.setText("Time : " + CalendarUtil.formattedTime(time));
    }

    private void intWidgets() {
        eventName = findViewById(R.id.eventName);
        eventDateView = findViewById(R.id.eventDateView);
        eventTime = findViewById(R.id.eventTime);
    }

    public void saveEvent(View view) {
        String eventNames = eventName.getText().toString();
        Event newEvent = new Event(eventNames, CalendarUtil.selectedDate, time);
        Event.eventsList.add(newEvent);
        finish();
    }
}