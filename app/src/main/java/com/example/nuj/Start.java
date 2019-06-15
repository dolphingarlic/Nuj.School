package com.example.nuj;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Start extends AppCompatActivity {

    private Button btnStart;
    private EditText nameInput;

    SharedPreferences sp;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = this.getSharedPreferences("login", MODE_PRIVATE);

        // Automatically logs the user in and takes them to the home screen when they launch the program again
        if (sp.getBoolean("logged",false)) {
            startActivity(new Intent(this, MainActivity.class));
        }

        // Gives functionality to the Start button
        addStartButton();
    }

    public void addStartButton() {

        final Context context = this;
        final ManageTextFile createUser = new ManageTextFile();

        final Calendar myCalendar = Calendar.getInstance();

        final EditText edittext = findViewById(R.id.Birthday);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            private void updateLabel() {
                edittext.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(Start.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // Creates the start button and allows it to be pressed
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Launches the home screen
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

                //stores all the user's info into a text file
                createUser.saveInfo(
                        getNameInput(),
                        sdf.format(myCalendar.getTime()),
                        sdf.format(getCurrentDate()),
                        getApplicationContext());

                // Edits the Shared preference to automatically log the user in when they launch the program again
                sp.edit().putBoolean("logged",true).apply();

            }

        });

    }

    public String getNameInput() {

        // Finds the editable text field component on the screen
        nameInput = findViewById(R.id.nameInput);

        // Stores the name that the user enters as a String
        String name = nameInput.getText().toString();

        // Returns the name that the user enters in the login screen
        return name;
    }

    public Date getCurrentDate(){

        Date currentDate = Calendar.getInstance().getTime();

        // Generates the current date and converts it into a formatted String
        //String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        // Returns the current date as a String using the format "yyyy-MM-dd"
        return currentDate;
    }




}
