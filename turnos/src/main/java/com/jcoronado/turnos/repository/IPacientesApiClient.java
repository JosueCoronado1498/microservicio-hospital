package com.jcoronado.turnos.repository;

import com.jcoronado.turnos.model.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "pacientesapi", url="http://pacientes-app:8080/pacientes")
public interface IPacientesApiClient {

    @GetMapping("/traerdni/{dni}")
    public Paciente getPaciente (@PathVariable("dni") String dni);

}
