package com.agendamento.agendaconsultas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class HomeController {

    @GetMapping
    public String inicio() {
        return "inicio";
    }
}
