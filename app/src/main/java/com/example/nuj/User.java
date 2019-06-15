package com.example.nuj;

import java.util.Date;
import java.util.List;


public class User {

    private String name;
    private Date birthday;
    private Date joinedDate;

    private List<Goal> allGoals;
    private List<Goal> completedGoals;
    private List<Goal> ongoingGoals;

    private double average;
    private double deviation;
    private int[] daysTaken;

    // Constructor method
    public User(String name, Date birthday, Date joinedDate, List<Goal> allGoals, List<Goal> completedGoals, List<Goal> ongoingGoals){
        this.name = name;
        this.birthday = birthday;
        this.joinedDate = new Date();
        this.allGoals = allGoals;
        this.completedGoals = completedGoals;
        this.ongoingGoals = ongoingGoals;
        calculateAverage();
        calculateDeviation();
    }

    // Method to calculate user's average
    public void calculateAverage(){
        double total = 0;

        for(int i = 0 ; i < daysTaken.length; i++){
            total = total + daysTaken[i];
        }

        average = total / daysTaken.length;
    }

    // Method to calculate user's deviation from their average
    public void calculateDeviation(){
            double sum = 0.0, standardDeviation = 0.0;
            int length = daysTaken.length;

            for(double num : daysTaken) {
                sum += num;
            }

            double mean = sum/length;

            for(double num: daysTaken) {
                standardDeviation += Math.pow(num - mean, 2);
            }

            deviation = Math.sqrt(standardDeviation/length);
        }

    }


