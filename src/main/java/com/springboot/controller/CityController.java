package com.springboot.controller;

import com.springboot.common.constant.StatusConstant;
import com.springboot.common.entity.Resp;
import com.springboot.entity.City;
import com.springboot.mapper.CityMapper;
import com.springboot.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by htc on 2017/9/28.
 */
@RequestMapping(value = "city")
@RestController
public class CityController {
    private final static Logger logger=LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Resp get() {
        System.out.println("city");
        List<City> cities = null;
        try {
            cities = cityService.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Resp(StatusConstant.HTTP_SUCCESS, cities);
    }


    @Autowired
    private CityMapper cityMapper;
    @RequestMapping(value = "getAll")
    public Resp getAll(){
        List<City> cities=cityMapper.findAll();
        return new Resp(StatusConstant.HTTP_SUCCESS,cities);
    }
}
