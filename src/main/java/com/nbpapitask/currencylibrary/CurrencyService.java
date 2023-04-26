package com.nbpapitask.currencylibrary;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {
    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Double getRateByDateAndCurrency(String sign, LocalDate localDate) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/%s/%s/?format=json".formatted(sign, localDate.toString());
        Rate[] rates = this.restTemplate.getForObject(url, CurrencyDTO.class).rates;
        double acc = 0;
        for (Rate rate : rates) {
            acc += rate.mid;
        }
        acc /= rates.length;
        return acc;
    }

    public MinMax getMinMax(String sign, int counting) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/%s/last/%s/".formatted(sign, counting);
        Rate[] rates = this.restTemplate.getForObject(url, CurrencyDTO.class).rates;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (Rate rate:
             rates) {
            double value = rate.mid;
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        return new MinMax(min, max);
    }

//    public MinMax getMax(String sign, int counting) {
//        String url = "http://api.nbp.pl/api/exchangerates/rates/A/%s/last/%s/".formatted(sign, counting);
//        Rate[] rates = this.restTemplate.getForObject(url, CurrencyDTO.class).rates;
//        double min = Double.MAX_VALUE;
//        double max = Double.MIN_VALUE;
//        Rate rate;
//        for (rate:
//             rates) {
//            double value = rate.mid;
//            if (value < min) {
//                min = value;
//            }
//            if (value > max) {
//                max = value;
//            }
//        }
//        return max;
//    }

    public BuyAsk getBuyAsk(String sign) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/%s/last/%s/".formatted(sign);
        Rate[] rates = this.restTemplate.getForObject(url, CurrencyDTO.class).rates;

        return null;
    }
}

