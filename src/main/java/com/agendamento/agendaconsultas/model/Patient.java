package com.agendamento.agendaconsultas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patient",
        schema = "public")
@Getter
@Setter
public class Patient extends UserSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String email;

}
