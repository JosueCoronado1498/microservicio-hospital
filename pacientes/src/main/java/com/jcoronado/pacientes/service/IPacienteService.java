package com.jcoronado.pacientes.service;

import com.jcoronado.pacientes.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPacienteService {

    //Crear
    public void savePaciente(Paciente pac);

    //Traer todos
    public List<Paciente> getPacientes();

    //Eliminar
    public void deletePaciente(Long id);

    //Traer por id
    public Paciente findPaciente(Long id);

    //Modificar
    public void editPaciente(Long id, Paciente pac);

    //Traer por dni
    public Paciente findPacienteByDni(String dni);

}
