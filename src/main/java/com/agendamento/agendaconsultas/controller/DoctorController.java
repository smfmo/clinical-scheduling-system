package com.agendamento.agendaconsultas.controller;

import com.agendamento.agendaconsultas.model.Doctor;
import com.agendamento.agendaconsultas.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Doctor doctor) {
        service.create(doctor);
        return ResponseEntity.created(null).build();
    }
}
