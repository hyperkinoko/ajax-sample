package net.kinokolabo.reservation.mapper;

import net.kinokolabo.reservation.domain.Open;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.sql.Date;

@Mapper
public interface OpenMapper {
    ArrayList<Open> selectAll();
    ArrayList<Open> selectAllWithDateRange(Date start, Date end);
}
