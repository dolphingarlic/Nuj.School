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
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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

        btnNewGoal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

            }
        });

        btnHelpOthers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                toHelpOthers();
            }
        });

    }

    // Links button to Get Help screen
    public void toGetHelp(View view){
        Intent intent = new Intent(this, GetHelp.class);
        startActivity(intent);
    }

    // Links button to About screen
    public void toAbout(View view){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    // Links button to Help Others screen
    public void toHelpOthers(){
        Intent intent = new Intent(this, HelpOthers.class);
        startActivity(intent);
    }



}
