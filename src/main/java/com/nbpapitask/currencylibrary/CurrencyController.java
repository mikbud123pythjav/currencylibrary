package com.nbpapitask.currencylibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping("/currency-library")
public class CurrencyController {
    private CurrencyService currencyService;


    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping(path = "/average/{sign}/{localDate}")
    public Average averageExchangeRate(@PathVariable String sign, @PathVariable LocalDate localDate) {
        return new Average(currencyService.getRateByDateAndCurrency(sign, localDate));
    }

//    @GetMapping("/minMax")
//    public MinMax minimalMaximalValue() {
//        return null;
//    }
//
//    @GetMapping("/buyAsk")
//    public double buyAskValue() {
//        return 0;
//    }
}
