package com.chenshun.test.controller;

import com.chenshun.test.model.City;
import com.chenshun.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User: chenshun131 <p />
 * Time: 18/8/2 16:03  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
@RequestMapping(value = "/city")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Mono<City> findOneCity(@PathVariable("id") Long id) {
        System.err.println("findOneCity 1");
        Mono mono = Mono.create(cityMonoSink -> cityMonoSink.success(cityService.findCityById(id)));
        System.err.println("findOneCity 3");
        return mono;
    }

    /**
     * Flux<Object> 支持REST风格的 JSON 和 XML 序列化和反序列化
     * 处理函数，它将数据库中发现的所有 City 对象返回为JSON。
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Flux<City> findAllCity() {
        System.err.println("findAllCity 1");
        Flux flux = Flux.create(cityFluxSink -> {
            cityService.findAllCity().forEach(cityFluxSink::next);
            cityFluxSink.complete();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("findAllCity 2");
        });
        System.err.println("findAllCity  end 3");
        return flux;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Mono<Long> createCity(@RequestBody City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.saveCity(city)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Mono<Long> modifyCity(@RequestBody City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.updateCity(city)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Mono<Long> modifyCity(@PathVariable("id") Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.deleteCity(id)));
    }

}
