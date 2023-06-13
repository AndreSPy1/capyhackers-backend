package com.nisum.capyhackers.controllers;

import com.nisum.capyhackers.dtos.PacienteDTO;
import com.nisum.capyhackers.dtos.PacienteRequestDTO;
import com.nisum.capyhackers.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/Paciente")
@CrossOrigin
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;
    @PostMapping
    private PacienteDTO crearPaciente(@RequestBody PacienteRequestDTO paciente) throws ParseException {
        return pacienteService.create(paciente);
    }
}
