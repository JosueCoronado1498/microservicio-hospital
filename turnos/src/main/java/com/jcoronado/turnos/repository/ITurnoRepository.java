package com.jcoronado.turnos.repository;

import com.jcoronado.turnos.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository <Turno, Long> {
}
