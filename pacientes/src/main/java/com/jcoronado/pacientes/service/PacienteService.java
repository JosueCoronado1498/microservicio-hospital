package com.jcoronado.pacientes.service;

import com.jcoronado.pacientes.model.Paciente;
import com.jcoronado.pacientes.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepo;

    @Override
    public void savePaciente(Paciente pac) {

        pacienteRepo.save(pac);
    }

    @Override
    public List<Paciente> getPacientes() {

        return pacienteRepo.findAll();
    }

    @Override
    public void deletePaciente(Long id) {

        pacienteRepo.deleteById(id);
    }

    @Override
    public Paciente findPaciente(Long id) {

        return pacienteRepo.findById(id).orElse(null);
    }

    @Override
    public void editPaciente(Long id, Paciente pac) {

        this.savePaciente(pac);
    }

    @Override
    public Paciente findPacienteByDni(String dni) {
        System.out.println("Buscando paciente con dni: " + dni);
        Paciente pac = pacienteRepo.findByDni(dni);
        if (pac == null) {
            System.out.println("Paciente no encontrado");
        }
        return pac;
        //return pacienteRepo.findByDni(dni);

    }
}
