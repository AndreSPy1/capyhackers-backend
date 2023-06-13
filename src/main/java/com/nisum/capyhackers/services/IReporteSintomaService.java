package com.nisum.capyhackers.services;

import com.nisum.capyhackers.dtos.ReporteEnfermedadDTO;
import com.nisum.capyhackers.dtos.ReporteSintomaRequestDTO;

import java.util.List;

public interface IReporteSintomaService {
    List<ReporteEnfermedadDTO> registrarReportesyObtenerReportesEnfermedad(List<ReporteSintomaRequestDTO> reporteSintomaRequestDTOList);
}
