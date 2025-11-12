package com.jcoronado.turnos.service;

import com.jcoronado.turnos.model.Paciente;
import com.jcoronado.turnos.model.Turno;
import com.jcoronado.turnos.repository.IPacientesApiClient;
import com.jcoronado.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepo;

    @Autowired
    private IPacientesApiClient pacientesApiClient;

    @Override
    public List<Turno> getTurnos() {

        return turnoRepo.findAll();
    }


    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        //buscar el paciente en la api pacientes
        Paciente pac = pacientesApiClient.getPaciente(dniPaciente);
        String nombreCompletoPaciente = pac.getNombre() + "" + pac.getApellido();

        Turno turn = new Turno();
        turn.setFecha(fecha);
        turn.setTratamiento(tratamiento);
        turn.setNombreCompletoPaciente(nombreCompletoPaciente);

        turnoRepo.save(turn);

    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
        Turno turn = this.findTurno(id);

        turn.setFecha(turno.getFecha());
        turn.setTratamiento(turno.getTratamiento());
        turn.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

        turnoRepo.save(turn);
    }

}
