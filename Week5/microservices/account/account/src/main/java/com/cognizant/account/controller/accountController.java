package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class accountController {

    @GetMapping("/details")
    public String getAccountDetails() {
        return "Account Details from Account Microservice";
    }
}
