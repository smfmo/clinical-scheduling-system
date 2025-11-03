package com.agendamento.agendaconsultas.repository;

import com.agendamento.agendaconsultas.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, UUID> {
}
