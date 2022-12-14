package com.opensource.proxyservice.service;

import com.opensource.proxyservice.model.Country;

public interface ProxyService {
    Country getCountry(String alpha);
}
