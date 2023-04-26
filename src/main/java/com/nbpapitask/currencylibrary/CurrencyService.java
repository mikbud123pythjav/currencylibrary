package com.nbpapitask.currencylibrary;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDate;

@Service
public class CurrencyService {
    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

//    LocalDate localDate,
    public Rate getRateByDateAndCurrency( String sign) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/%s/?format=json".formatted(sign);
        return this.restTemplate.getForObject(url, Rate.class);
    }
}