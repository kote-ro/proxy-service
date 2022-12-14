package com.opensource.proxyservice.controller;

import com.opensource.proxyservice.model.Country;
import com.opensource.proxyservice.service.ProxyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    private final ProxyService proxyService;

    public ProxyController(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @GetMapping("/country/{alpha}")
    Country getCountry(@PathVariable("alpha") String alpha){
        return proxyService.getCountry(alpha);
    }
}
