package com.nisum.capyhackers.services;

import com.nisum.capyhackers.Repositories.EnfermedadRepository;
import com.nisum.capyhackers.Repositories.PacienteRepository;
import com.nisum.capyhackers.Repositories.ReporteSintomaRepository;
import com.nisum.capyhackers.Repositories.SintomaRepository;
import com.nisum.capyhackers.dtos.ReporteEnfermedadDTO;
import com.nisum.capyhackers.dtos.ReporteSintomaDTO;
import com.nisum.capyhackers.dtos.ReporteSintomaRequestDTO;
import com.nisum.capyhackers.models.Enfermedad;
import com.nisum.capyhackers.models.Paciente;
import com.nisum.capyhackers.models.ReporteSintoma;
import com.nisum.capyhackers.models.Sintoma;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ReporteSintomaServiceImpl implements IReporteSintomaService{

    @Autowired
    ReporteSintomaRepository repository;
    @Autowired
    SintomaRepository sintomaRepository;
    @Autowired
    EnfermedadRepository enfermedadRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    IReporteEnfermedadService reporteEnfermedadService;

    ModelMapper mapper = new ModelMapper();
    @Override
    public List<ReporteEnfermedadDTO> registrarReportesyObtenerReportesEnfermedad(List<ReporteSintomaRequestDTO> reporteSintomaRequestDTOList) {
        List<ReporteSintomaDTO> reportesSintomasRegistrados = new ArrayList<>();
        List<ReporteEnfermedadDTO> reportesEnfermedades = new ArrayList<>();

        for (ReporteSintomaRequestDTO reporte : reporteSintomaRequestDTOList) {
            Sintoma sintomaModel = sintomaRepository.findById(reporte.getIdSintoma()).get();

            Paciente pacienteModel = pacienteRepository.findById(reporte.getIdPaciente()).get();

            ReporteSintoma reporteSintomaModel = new ReporteSintoma();
            reporteSintomaModel.setPorcentualSintoma(reporte.getPorcentualSintoma());
            reporteSintomaModel.setFechaReporteSintoma(new Date());
            reporteSintomaModel.setSintoma(sintomaModel);
            reporteSintomaModel.setPaciente(pacienteModel);

            ReporteSintoma reporteSintoma = repository.save(reporteSintomaModel);
            ReporteSintomaDTO reporteSintomaDTO = mapper.map(reporteSintoma, ReporteSintomaDTO.class);

            reportesSintomasRegistrados.add(reporteSintomaDTO);
        }

        //Encontrar sintomas por enfermedad...
        for (Enfermedad enfermedad : obtenerEnfermedades()) {
            List<ReporteSintoma> reporteSintomas = new ArrayList<>();
            for (ReporteSintomaDTO reporteSintomaDTO : reportesSintomasRegistrados) {
                if (Objects.equals(reporteSintomaDTO.getSintoma().getEnfermedad().getIdEnfermedad(), enfermedad.getIdEnfermedad())) {
                    reporteSintomas.add(mapper.map(reporteSintomaDTO, ReporteSintoma.class));
                }
            }

            if(!reporteSintomas.isEmpty()){
                int porcentual = 0;
                for (ReporteSintoma reporteSintoma : reporteSintomas) {
                    porcentual = porcentual + reporteSintoma.getPorcentualSintoma();
                }

                Paciente paciente = new Paciente();
                paciente.setIdPaciente(reporteSintomaRequestDTOList.get(0).getIdPaciente());

                ReporteEnfermedadDTO reporteEnfermedadDTO = ReporteEnfermedadDTO.builder()
                        .fechaReporteEnfermedad(new Date())
                        .porcentualTotal(porcentual)
                        .enfermedad(enfermedad)
                        .paciente(paciente).build();
                ReporteEnfermedadDTO reporteEnfermedadDTO1 =
                        reporteEnfermedadService.registrarReporte(reporteEnfermedadDTO);

                reportesEnfermedades.add(reporteEnfermedadDTO1);
            }
        }

        return reportesEnfermedades;
    }

    private List<Enfermedad> obtenerEnfermedades(){
        return enfermedadRepository.findAll();
    }
}
