package com.nbpapitask.currencylibrary;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class CurrencyService {
    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

//    LocalDate localDate,
    public Double getRateByDateAndCurrency(String sign, LocalDate localDate) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/%s/%s/?format=json".formatted(sign,localDate.toString());
        Rate[] rates = this.restTemplate.getForObject(url, CurrencyDTO.class).rates;
        double acc = 0;
        for(Rate rate : rates){
            acc+=rate.mid;
        }
        acc/=rates.length;
        return acc;
    }
    public double getMinMax(String sign, int topCount) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/%s/last/%s/".formatted(sign,topCount);
        return 0;
    }
}