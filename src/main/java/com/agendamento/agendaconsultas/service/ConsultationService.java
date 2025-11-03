package com.agendamento.agendaconsultas.service;

import com.agendamento.agendaconsultas.model.Consultation;
import com.agendamento.agendaconsultas.repository.ConsultationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public ConsultationService(ConsultationRepository consultationRepository,
                               DoctorService doctorService, PatientService patientService) {
        this.consultationRepository = consultationRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }


    @Transactional
    public Consultation create(Consultation consultation) {
        validate(consultation.getPatientId(), consultation.getDoctorId());
        return consultationRepository.save(consultation);
    }

    private void validate(UUID doctorId, UUID patientId) {
        if (doctorId == null) {
            throw new IllegalArgumentException("Doutor inexistente");
        }
        if (patientId == null) {
            throw new IllegalArgumentException("Paciente inexistente");
        }
    }
}
