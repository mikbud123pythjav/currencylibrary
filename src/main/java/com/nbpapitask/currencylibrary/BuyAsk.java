package com.nbpapitask.currencylibrary;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class BuyAsk {
    public String no;
    public LocalDate effectiveDate;
    public double bid;
    public double ask;
}
