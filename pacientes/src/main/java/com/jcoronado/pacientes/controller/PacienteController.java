package com.jcoronado.pacientes.controller;

import com.jcoronado.pacientes.model.Paciente;
import com.jcoronado.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private IPacienteService pacienteServ;

    @PostMapping("/pacientes/crear")
    public String crearPaciente(@RequestBody Paciente pac){
        pacienteServ.savePaciente(pac);

        return "El paciente se creo correctamente";
    }

    @GetMapping("/pacientes/traer")
    public List<Paciente> traerPacientes(){
        return pacienteServ.getPacientes();
    }

    @DeleteMapping("/pacientes/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Long id){
        pacienteServ.deletePaciente(id);

        return "El paciente se elimino correctamente";
    }

    @GetMapping("/pacientes/traerdni/{dni}")
    public Paciente traerPacientePorDni(@PathVariable("dni") String dni){

        return pacienteServ.findPacienteByDni(dni);
    }

    @PutMapping("/pacientes/editar/{id_original}")
    public Paciente editarPaciente(@PathVariable Long id_original,
                                   @RequestBody Paciente pacienteEditar){
        pacienteServ.editPaciente(id_original, pacienteEditar);
        Paciente pacienteEditado = pacienteServ.findPaciente(id_original);

        return pacienteEditado;
    }

}
