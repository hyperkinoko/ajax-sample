package net.kinokolabo.reservation.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.kinokolabo.reservation.domain.Open;

@Mapper
public interface OpenMapper {
    ArrayList<Open> selectAll();
    boolean deleteAll();
    int insert(ArrayList<Open> list);
}
