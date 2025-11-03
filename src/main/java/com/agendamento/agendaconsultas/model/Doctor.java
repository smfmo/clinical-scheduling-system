package com.agendamento.agendaconsultas.model;

import com.agendamento.agendaconsultas.model.enums.Specialty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "doctor",
        schema = "public")
@Getter @Setter
public class Doctor extends UserSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String Crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

}
