package com.example.nuj;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ManageTextFile {

    private String userName;
    private Date birthday;
    private Date joinedDate;

    private static final String NUJ_USER_TXT = "NujUser.txt";

    public String getUserName() {
        return userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void saveInfo(String name, String birthday, String joinedDate, Context ctx) {

        try {
            Writer writeToFile = new FileWriter(new File(ctx.getFilesDir(), NUJ_USER_TXT));
            writeToFile.write(name + "#" + birthday + "#" + joinedDate);
            writeToFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readUserInfo(Context ctx) {

        try {
            Scanner readFromFile = new Scanner(new File(ctx.getFilesDir(), NUJ_USER_TXT)).useDelimiter("#");

            while (readFromFile.hasNext()){
                userName = readFromFile.next();
                birthday = getDate(readFromFile.next());
                joinedDate = getDate(readFromFile.next());
            }
            readFromFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Date getDate(String day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        Date date = new Date();
        try {
            date = dateFormat.parse(day);
        } catch (ParseException e) {}
        return date;
    }

}
