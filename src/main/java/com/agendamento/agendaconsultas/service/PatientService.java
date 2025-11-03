package com.agendamento.agendaconsultas.service;

import com.agendamento.agendaconsultas.model.Patient;
import com.agendamento.agendaconsultas.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(Patient patient) {
        repository.save(patient);
    }
}
