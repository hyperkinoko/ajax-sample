package net.kinokolabo.reservation.mapper;

import net.kinokolabo.reservation.domain.Mokumoku;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MokumokuMapper {
    Mokumoku select();
    boolean update(Mokumoku m);
}
