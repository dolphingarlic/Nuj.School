package com.example.nuj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toGetHelp(View view){
        Intent intent = new Intent(this, GetHelp.class);
        startActivity(intent);
    }

    public void toAbout(View view){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void toHelpOthers(View view){
        Intent intent = new Intent(this, HelpOthers.class);
        startActivity(intent);
    }
}
