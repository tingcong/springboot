package com.springboot.mapper;

import com.springboot.entity.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by htc on 2017/9/30.
 */
@Mapper
public interface CityMapper {
    List<City> findAll();
}
