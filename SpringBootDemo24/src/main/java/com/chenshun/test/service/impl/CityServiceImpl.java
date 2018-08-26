package com.chenshun.test.service.impl;

import com.chenshun.test.model.City;
import com.chenshun.test.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/8/2 16:02  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Service
public class CityServiceImpl implements CityService {

    /** 模拟数据库，存储 City 信息 */
    private static Map<Long, City> CITY_DB = new HashMap<>();

    @Override
    public List<City> findAllCity() {
        return new ArrayList<>(CITY_DB.values());
    }

    @Override
    public City findCityById(Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("findOneCity 2");
        return CITY_DB.get(id);
    }

    @Override
    public Long saveCity(City city) {
        city.setId(CITY_DB.size() + 1L);
        CITY_DB.put(city.getId(), city);
        return city.getId();
    }

    @Override
    public Long updateCity(City city) {
        CITY_DB.put(city.getId(), city);
        return city.getId();
    }

    @Override
    public Long deleteCity(Long id) {
        CITY_DB.remove(id);
        return id;
    }

}
