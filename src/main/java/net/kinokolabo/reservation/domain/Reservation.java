package net.kinokolabo.reservation.domain;

import java.sql.Timestamp;

public class Reservation {
    private int id;
    private Timestamp startDatetime;
    private Timestamp endDatetime;
    private int studentId;
    private int price;
    private int attended;
    private boolean addToCal;
    private boolean paid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getStartDatetime() {
		return startDatetime;
	}
	public void setStartDatetime(Timestamp startDatetime) {
		this.startDatetime = startDatetime;
	}
	public Timestamp getEndDatetime() {
		return endDatetime;
	}
	public void setEndDatetime(Timestamp endDatetime) {
		this.endDatetime = endDatetime;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}



}
