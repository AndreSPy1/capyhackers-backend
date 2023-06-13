package com.nisum.capyhackers.services;

import com.nisum.capyhackers.dtos.PacienteDTO;
import com.nisum.capyhackers.dtos.PacienteRequestDTO;

import java.text.ParseException;

public interface IPacienteService {
    PacienteDTO create(PacienteRequestDTO paciente) throws ParseException;
}
