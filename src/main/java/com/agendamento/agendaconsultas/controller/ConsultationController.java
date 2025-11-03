package com.agendamento.agendaconsultas.controller;

import com.agendamento.agendaconsultas.model.Consultation;
import com.agendamento.agendaconsultas.service.ConsultationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    private final ConsultationService service;

    public ConsultationController(ConsultationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Consultation> create(@RequestBody Consultation consultation) {
        service.create(consultation);
        return ResponseEntity.ok().body(consultation);
    }
}
