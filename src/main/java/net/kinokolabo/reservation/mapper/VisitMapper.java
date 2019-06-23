package net.kinokolabo.reservation.mapper;

import net.kinokolabo.reservation.domain.Student;
import net.kinokolabo.reservation.domain.Visit;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Mapper
public interface VisitMapper {
    Visit selectByStudentIdAndTime(int studentId, Timestamp time);
    int insert(Visit visit);
    boolean update(Visit visit);
    boolean delete(int id);
}
