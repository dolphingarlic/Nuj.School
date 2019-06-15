package com.example.nuj;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpOthers extends AppCompatActivity {

// Creates the GUI on launch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_others);
    }

// Method linked to back button that takes user to home screen
    public void toHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

// Sends user to website for general help
    public void goToGeneralHelp (View view) {
        goToUrl ( "https://www.mentalhealth.org.uk/publications/supporting-someone-mental-health-problem");
    }

// Sends user to website for depression help
    public void goToDepressionHelp (View view) {
        goToUrl ( "https://www.helpguide.org/articles/depression/coping-with-depression.htm");
    }

// Sends user to website for anxiety help
    public void goToAnxietyHelp (View view) {
        goToUrl ( "https://www.helpguide.org/articles/anxiety/anxiety-disorders-and-anxiety-attacks.htm");
    }

// Sends user to website for anxiety help
    public void goToEDHelp (View view) {
        goToUrl ( "https://www.helpguide.org/articles/eating-disorders/helping-someone-with-an-eating-disorder.htm");
    }

// Method that launches browser and sends user to specific website
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
