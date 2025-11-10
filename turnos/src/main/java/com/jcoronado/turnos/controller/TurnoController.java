package com.jcoronado.turnos.controller;

import com.jcoronado.turnos.model.Turno;
import com.jcoronado.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoServ;

    //Crear un nuevo turno
    @PostMapping("/crear")
    public String crearTurno(@RequestBody LocalDate fecha,
                             @RequestBody String tratamiento,
                             @RequestBody String dniPaciente){
        turnoServ.saveTurno(fecha, tratamiento, dniPaciente);

        return "El turno se creo correctamente";
    }

    @GetMapping("/traer")
    public List<Turno> traerTurnos(){
        return turnoServ.getTurnos();
    }

    @DeleteMapping("/eliminar")
    public String eliminarTurno(@PathVariable Long id){
        turnoServ.deleteTurno(id);

        return "El turno se elimino correctamente";
    }

}
