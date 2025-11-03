package com.agendamento.agendaconsultas.service;

import com.agendamento.agendaconsultas.model.Doctor;
import com.agendamento.agendaconsultas.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(Doctor doctor) {
        repository.save(doctor);
    }

}
