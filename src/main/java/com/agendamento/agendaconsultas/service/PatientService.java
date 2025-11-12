package com.agendamento.agendaconsultas.service;

import com.agendamento.agendaconsultas.model.Patient;
import com.agendamento.agendaconsultas.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void registerPatient(Patient patient) {
        repository.save(patient);
    }

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient findById(UUID patientId) {
        return repository.findById(patientId).orElse(null);
    }

    public void deletePatient(UUID patientId) {
        repository.deleteById(patientId);
    }
}
