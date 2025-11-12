package com.agendamento.agendaconsultas.service;

import com.agendamento.agendaconsultas.model.Doctor;
import com.agendamento.agendaconsultas.model.enums.Specialty;
import com.agendamento.agendaconsultas.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void registerDoctor(Doctor doctor) {
        repository.save(doctor);
    }

    public List<Doctor> findAll() {
        return repository.findAll();
    }

    public List<Doctor> findDoctorBySpeciality(Specialty specialty) {
        return repository.searchBySpeciality(specialty);
    }

    public Doctor getById(UUID doctorId) {
        return repository.findById(doctorId).orElse(null);
    }

    public void deleteDoctor(UUID doctorId) {
        repository.deleteById(doctorId);
    }
}
