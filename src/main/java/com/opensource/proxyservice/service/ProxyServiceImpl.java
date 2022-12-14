package com.opensource.proxyservice.service;

import com.opensource.proxyservice.model.Country;
import com.opensource.proxyservice.model.CountryMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProxyServiceImpl implements ProxyService{
    private final WebClient webClient;
    @Value("${rest.countries.uri}")
    private String countriesUri;

    public ProxyServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    public Country getCountry(String alpha){
        var mono = webClient.get()
                .uri(countriesUri, alpha)
                .retrieve()
                .bodyToMono(String.class);
        return CountryMapper.getCountryFromJson(mono.block()); // use of block only for non-reactive app
    }
}
