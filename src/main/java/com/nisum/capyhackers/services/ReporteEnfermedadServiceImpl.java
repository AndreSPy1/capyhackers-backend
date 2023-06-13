package com.nisum.capyhackers.services;

import com.nisum.capyhackers.Repositories.ReporteEnfermedadRepository;
import com.nisum.capyhackers.dtos.ReporteEnfermedadDTO;
import com.nisum.capyhackers.models.ReporteEnfermedad;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteEnfermedadServiceImpl implements IReporteEnfermedadService{

    @Autowired
    ReporteEnfermedadRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ReporteEnfermedadDTO registrarReporte(ReporteEnfermedadDTO reporteEnfermedadDTO) {
        ReporteEnfermedad reporteEnfermedad = modelMapper.map(reporteEnfermedadDTO, ReporteEnfermedad.class);
        ReporteEnfermedadDTO reporteEnfermedadDTO1 = modelMapper.map(
                repository.save(reporteEnfermedad), ReporteEnfermedadDTO.class);
        return reporteEnfermedadDTO1;
    }
}
