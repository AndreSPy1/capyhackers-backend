package com.nisum.capyhackers.services;

import com.nisum.capyhackers.Repositories.PacienteRepository;
import com.nisum.capyhackers.dtos.PacienteDTO;
import com.nisum.capyhackers.dtos.PacienteRequestDTO;
import com.nisum.capyhackers.models.Paciente;
import com.nisum.capyhackers.utils.FechaUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
public class PacienteServiceImpl implements IPacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;
    ModelMapper mapper = new ModelMapper();
    @Override
    public PacienteDTO create(PacienteRequestDTO paciente) throws ParseException {
        Date date = FechaUtil.formatDate(paciente.getFechaNacimiento());
        PacienteDTO pacienteDTO = PacienteDTO.builder()
                .nombrePaciente(paciente.getNombrePaciente())
                .generoPaciente(paciente.getGeneroPaciente())
                .fechaNacimiento(date).build();

        Paciente pacienteModel = mapper.map(pacienteDTO, Paciente.class);

        PacienteDTO pacienteResponseDTO = mapper.map(pacienteRepository.save(pacienteModel), PacienteDTO.class);
        return pacienteResponseDTO;
    }
}
