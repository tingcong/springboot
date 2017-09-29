package com.springboot.service;

import com.springboot.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by htc on 2017/9/28.
 */
public interface CityService {
    List<City> get();
}
