package net.kinokolabo.reservation.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Open {
    int id;
    Date date;
    ArrayList<TimeRange> opens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<TimeRange> getOpens() {
        return opens;
    }

    public void setOpens(ArrayList<TimeRange> opens) {
        this.opens = opens;
    }
}
