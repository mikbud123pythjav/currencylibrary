package com.nbpapitask.currencylibrary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@RestController
@Controller
@RequestMapping("/currency-library")
public class CurrencyController {
    CurrencyRepository currencyRepository;

    @GetMapping("/HTML")
    public String getHTMLPage() {
        return "index";
    }
    @PostMapping("/save-project")
    public String saveProjectSubmission(@ModelAttribute Currency currency) {

        // TODO: save project in DB here

        return "result";
    }
}


