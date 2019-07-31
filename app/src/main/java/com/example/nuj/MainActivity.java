package com.example.nuj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnNewGoal;
    private ImageButton btnHelpOthers;
    private ImageButton btnGetHelp;
    private ImageButton btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Instantiates a user object using the user's info stored in the text file
        ManageTextFile textFile = new ManageTextFile();
        textFile.readUserInfo(this);
        ManageDatabase db = new ManageDatabase(this);
        User user = new User(
                textFile.getUserName(),
                textFile.getBirthday(),
                textFile.getJoinedDate(),
                db.allGoals(),
                db.completedGoals(),
                db.ongoingGoals());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewGoal = findViewById(R.id.btnNewGoal);
        btnHelpOthers = findViewById(R.id.btnHelpOthers);
        btnGetHelp = findViewById(R.id.btnGetHelp);
        btnAbout = findViewById(R.id.btnAbout);

        // Button click allows user to add a new goal
        btnNewGoal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                toNewGoal();
            }
        });

        // Button click takes user to Help Others screen
        btnHelpOthers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                toHelpOthers();
            }
        });

        // Button click takes user to Get Help screen
        btnGetHelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                toGetHelp();
            }
        });

        // Button click takes user to About screen
        btnAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                toAbout();
            }
        });

    }

    // Links button to New Goal screen
    public void toNewGoal(){
        Intent intent = new Intent(this, NewGoal.class);
        startActivity(intent);
    }

    // Links button to Get Help screen
    public void toGetHelp(){
        Intent intent = new Intent(this, GetHelp.class);
        startActivity(intent);
    }

    // Links button to About screen
    public void toAbout(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    // Links button to Help Others screen
    public void toHelpOthers(){
        Intent intent = new Intent(this, HelpOthers.class);
        startActivity(intent);
    }

    // Stops the user from navigating back to the login screen
    @Override
    public void onBackPressed() {
    }

}
