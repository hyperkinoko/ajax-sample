package net.kinokolabo.reservation.mapper;

import net.kinokolabo.reservation.domain.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.ArrayList;

@Mapper
public interface ReservationMapper {
    ArrayList<Reservation> selectAll();
    ArrayList<Reservation> selectAllWithDateRange(Date from, Date to);
    ArrayList<Reservation> selectByUser(String userId);
    ArrayList<Reservation> selectByUserWithDateRange(String userId, Date from, Date to);
    ArrayList<Reservation> selectNotAddedToCal();
}
