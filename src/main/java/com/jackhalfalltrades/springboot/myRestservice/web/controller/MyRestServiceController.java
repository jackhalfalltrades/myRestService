package com.jackhalfalltrades.springboot.myRestservice.web.controller;

import com.jackhalfalltrades.springboot.myRestservice.model.City;
import com.jackhalfalltrades.springboot.myRestservice.service.MyRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestServiceController {

    @Autowired
    MyRestService myRestService;

    @GetMapping(value = "/cities/{location}")
    public City getCities(@RequestBody @PathVariable String location) {
    return myRestService.getCity(location);
    }
}
