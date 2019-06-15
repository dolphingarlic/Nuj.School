package com.example.nuj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nuj.ui.about.AboutFragment;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        // TODO: Fix this if statement
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, AboutFragment.newInstance())
//                    .commitNow();
//        }
    }

    public void toHome(View view){
        this.finish();
    }

    public void toAboutAnqi(View view){
        Intent intent = new Intent(this, AboutAnqi.class);
        startActivity(intent);
    }
}
