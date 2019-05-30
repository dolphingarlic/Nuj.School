package com.example.nuj;


import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;


public class User {

    private static final String NUJ_USER_TXT = "NujUser.txt";
    EditText mEditText;

    private String name;
    private Date birthday;
    private double averageWeeklyGoals;
    Goal[] completedGoals;
    Goal[] ongoingGoals;
    private double deviation;
    private Date joinedDate;


    public User(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
        this.joinedDate = new Date();
    }

    public void saveInfo() {
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(NUJ_USER_TXT, MODE_PRIVATE);
            fos.write(text.getBytes());

            mEditText.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + NUJ_USER_TXT,
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public double getDeviation() {
        return deviation;
    }

    public double getAverageWeeklyGoals(){
        return averageWeeklyGoals;
    }

}
