package com.nbpapitask.currencylibrary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CurrencyController {
    CurrencyRepository currencyRepository;
    @GetMapping("/index")
    public String getHTMLPage(){
        return "index";
    }
    @GetMapping("/sql")
    public List<Currency> getSql(){
        return currencyRepository.getAll();
    }
}

