package com.agendamento.agendaconsultas.controller;

import com.agendamento.agendaconsultas.model.Patient;
import com.agendamento.agendaconsultas.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Patient patient) {
        service.create(patient);
        return ResponseEntity.created(null).build();
    }
}
