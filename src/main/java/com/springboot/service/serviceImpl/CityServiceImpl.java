package com.springboot.service.serviceImpl;

import com.springboot.entity.City;
import com.springboot.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htc on 2017/9/28.
 */
@Service
public class CityServiceImpl implements CityService{

//    @Autowired
//    private CityDao cityDao;

    @Override
    public List<City> get() {

//        List<City> cityList=cityDao.findByCity("上海");



        List<City> cities=new ArrayList<>();
        City city=new City();
        city.setCityId(1);
        city.setCity("上海");
        city.setCountryId(1);
        city.setLastUpdate("2017-09-28");
        cities.add(city);
        cities.add(new City(2,"北京",2,"2017-08-029"));
        cities.add(new City(3,"江西",2,"2017-08-029"));
        cities.add(new City(4,"杭州",2,"2017-08-029"));
        return cities;
    }
}
