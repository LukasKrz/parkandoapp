package com.parkando.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "To jest Parkando - aplikacja do rezerwowania miejsc parkingowych";
    }
}