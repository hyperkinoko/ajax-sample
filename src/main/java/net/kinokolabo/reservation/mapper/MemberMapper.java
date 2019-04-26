package net.kinokolabo.reservation.mapper;

import net.kinokolabo.reservation.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member selectById(int id);
    boolean insert(Member member);
    boolean update(Member member);
    boolean delete(int id);
}
