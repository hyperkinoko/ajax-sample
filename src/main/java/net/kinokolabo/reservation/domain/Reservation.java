package net.kinokolabo.reservation.domain;

import java.sql.Date;

public class Reservation {
    int id;
    Date startDate;
    Date endDate;
    int userId;
    int price;
    int attended;
    boolean addToCal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAttended() {
        return attended;
    }

    public void setAttended(int attended) {
        this.attended = attended;
    }

    public boolean isAddToCal() {
        return addToCal;
    }

    public void setAddToCal(boolean addToCal) {
        this.addToCal = addToCal;
    }
}
