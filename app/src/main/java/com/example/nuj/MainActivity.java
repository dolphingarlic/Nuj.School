package com.example.nuj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnNewGoal;
    private ImageButton btnHelpOthers;
    private ImageButton btnGetHelp;
    private ImageButton btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ManageTextFile textFile = new ManageTextFile();
        ManageDatabase db = new ManageDatabase(this);
        User user = new User(textFile.getUserName(), textFile.getBirthday(), textFile.getJoinedDate(), db.allGoals(), db.completedGoals(), db.ongoingGoals());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewGoal = (ImageButton)findViewById(R.id.btnNewGoal);
        btnHelpOthers = (ImageButton)findViewById(R.id.btnHelpOthers);
        btnGetHelp = (ImageButton)findViewById(R.id.btnGetHelp);
        btnAbout = (ImageButton)findViewById(R.id.btnAbout);

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
