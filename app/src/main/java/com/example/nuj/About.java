package com.example.nuj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nuj.ui.about.AboutFragment;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AboutFragment.newInstance())
                    .commitNow();
        }
    }
}
