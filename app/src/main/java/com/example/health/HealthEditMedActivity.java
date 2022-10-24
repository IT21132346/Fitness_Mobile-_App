package com.example.health;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class HealthEditMedActivity extends AppCompatActivity {

    DatePickerDialog datePickerDialog;
    EditText name, allergies, medConditions ;
    String dob ;
    Uri uri;
    Button dateButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_edit_med);

        initDatePicker();
        dateButton = findViewById(R.id.editDate);
        dateButton.setText(getTodayDate());
        name = findViewById(R.id.editName);
        medConditions = findViewById(R.id.editMedCon);
        allergies = findViewById(R.id.editAlgi);
        Button insert = findViewById(R.id.btnSubmit);
        Button gallery = findViewById(R.id.gallery);
        DB = new DBHelper(this);

    // For Image
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);
                uri = intent.getData();
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String dobTxt = dob;
                String allergiesTXT = allergies.getText().toString();
                String medConditionsTXT = medConditions.getText().toString();

//                // get Image
//                String imgPath = uri.toString();
//                Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
//                byte[] bytesImage = byteArrayOutputStream.toByteArray();

                // to DB
                Boolean checkInsertData = DB.insertUserData(nameTXT, dobTxt, allergiesTXT, medConditionsTXT);
                if (checkInsertData == true)
                    Toast.makeText(HealthEditMedActivity.this,"New Entry Inserted Successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(HealthEditMedActivity.this,"New Entry Insert Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getTodayDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
                dob = date;
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year) {
        dob = day + " " + getMonthFormat(month)+ " " + year;
        return day + " " + getMonthFormat(month)+ " " + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";
        return "JAN";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}