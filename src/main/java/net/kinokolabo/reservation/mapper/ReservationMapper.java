package net.kinokolabo.reservation.mapper;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.kinokolabo.reservation.domain.Reservation;

@Mapper
public interface ReservationMapper {
    ArrayList<Reservation> selectAll();
    ArrayList<Reservation> selectAllWithDateRange(Date from, Date to);
    ArrayList<Reservation> selectByStudent(int studentId);
    ArrayList<Reservation> selectByUserWithDateRange(String userId, Date from, Date to);
    ArrayList<Reservation> selectNotAddedToCal();
}
