package com.agendamento.agendaconsultas.model;

import com.agendamento.agendaconsultas.model.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "consultation",
        schema = "public")
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "patient_id")
    private UUID patientId;

    @JoinColumn(name = "doctor_id")
    private UUID doctorId;

    private LocalDate consultationDate;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Enumerated(EnumType.STRING)
    private Status status;

}
