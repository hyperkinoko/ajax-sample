package net.kinokolabo.reservation.mapper;

import net.kinokolabo.reservation.domain.Fruit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FruitMapper {
    List<Fruit> selectAll();
}
