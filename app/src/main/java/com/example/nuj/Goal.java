package com.example.nuj;

import java.util.Date;

public class Goal {

    private int id;
    private String description;
    private int difficulty;
    private Date start;
    private boolean completed;

    // Constructor method
    public Goal(String description, int difficulty, Date end) {
        this.description = description;
        this.difficulty = difficulty;
        this.start = new Date();
    }

    public Goal() {

    }

    // Getter and setter methods
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
