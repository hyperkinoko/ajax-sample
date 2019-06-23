package net.kinokolabo.reservation.domain;

import java.sql.Timestamp;

public class Visit {
    private int id = 0;
    private int studentId = 0;
    private JoinOrLeave joinOrLeave = JoinOrLeave.JOIN;
    private Timestamp time;
    private int courseId = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public JoinOrLeave getJoinOrLeave() {
        return joinOrLeave;
    }

    public void setJoinOrLeave(JoinOrLeave joinOrLeave) {
        this.joinOrLeave = joinOrLeave;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
