package com.example.nuj;

import java.util.Date;

public class Goal {

    private String description;
    private int days;
    private int difficulty;
    private Date start;
    private Date end;
    private boolean completed;

    public Goal(String description, int days, int difficulty, Date end) {
        this.description = description;
        this.days = days;
        this.difficulty = difficulty;
        this.start = new Date();
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
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

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
