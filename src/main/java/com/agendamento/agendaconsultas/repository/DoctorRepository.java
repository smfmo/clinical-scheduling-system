package com.agendamento.agendaconsultas.repository;

import com.agendamento.agendaconsultas.model.Doctor;
import com.agendamento.agendaconsultas.model.enums.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    @Query("SELECT d FROM Doctor d WHERE d.specialty = :speciality")
    List<Doctor> searchBySpeciality(Specialty specialty);
}
