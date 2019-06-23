package net.kinokolabo.reservation.mapper;

import net.kinokolabo.reservation.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    Student selectById(int id);
    int insert(Student student);
    boolean update(Student student);
    boolean delete(int id);
}
