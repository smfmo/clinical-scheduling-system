package com.agendamento.agendaconsultas.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UserSystem {

    private String name;
    private String cpf;
    private String telephone;
    private LocalDate dateBirthday;

    public UserSystem() {}

    public UserSystem(String name, String cpf, String telephone, LocalDate dateBirthday) {
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
        this.dateBirthday = dateBirthday;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public LocalDate getDateBirthday() {
        return dateBirthday;
    }
    public void setDateBirthday(LocalDate dateBirthday) {
        this.dateBirthday = dateBirthday;
    }
}
