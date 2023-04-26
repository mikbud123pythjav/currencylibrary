package com.nbpapitask.currencylibrary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyDTO {
    public String table;
    public String currency;
    public String code;
    public Rate[] rates;

}
