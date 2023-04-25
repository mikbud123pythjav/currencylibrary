package com.nbpapitask.currencylibrary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Currency> getAll(){
        List<Currency> currency = jdbcTemplate.query("SELECT currency_sign, currency_name, currency_mid", BeanPropertyRowMapper.newInstance(Currency.class));
        return currency;
    }
}
