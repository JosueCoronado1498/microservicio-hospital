package com.jcoronado.pacientes.repository;

import com.jcoronado.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository <Paciente, Long> {

    @Query("SELECT pac FROM Paciente pac WHERE pac.dni = :dni")
    Paciente findByDni(String dni);

}
