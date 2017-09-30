package com.springboot.mapper;

import com.springboot.entity.Person;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by htc on 2017/9/30.
 */
@Mapper
public interface PersonMapper {

    Person findUserById(Integer id);
}
