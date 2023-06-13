package com.nisum.capyhackers.controllers;

import com.nisum.capyhackers.dtos.ReporteEnfermedadDTO;
import com.nisum.capyhackers.dtos.ReporteSintomaRequestDTO;
import com.nisum.capyhackers.dtos.SintomaDTO;
import com.nisum.capyhackers.services.IReporteSintomaService;
import com.nisum.capyhackers.services.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SintomaController {

    @Autowired
    private ISintomaService sintomaService;
    @Autowired
    private IReporteSintomaService reporteSintomaService;

    @GetMapping("/Sintoma")
    private List<SintomaDTO> obtenerSintomas(){
        return sintomaService.obtenerSintomas();
    }

    @PostMapping("/Sintoma/Enfermedades")
    private List<ReporteEnfermedadDTO> registrarReportes(@RequestBody List<ReporteSintomaRequestDTO> reporteSintomaRequestDTOList){
        return reporteSintomaService.registrarReportesyObtenerReportesEnfermedad(reporteSintomaRequestDTOList);
    }
}
