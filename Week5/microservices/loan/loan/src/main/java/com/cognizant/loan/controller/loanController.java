package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class loanController {

    @GetMapping("/details")
    public String getLoanDetails() {
        return "Loan Details from Loan Microservice";
    }
}