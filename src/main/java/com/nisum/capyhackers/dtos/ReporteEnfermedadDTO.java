package com.nisum.capyhackers.dtos;

import com.nisum.capyhackers.models.Enfermedad;
import com.nisum.capyhackers.models.Paciente;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReporteEnfermedadDTO {
    private Integer idReporteEnfermedad;
    private Date fechaReporteEnfermedad;
    private Integer porcentualTotal;
    private Enfermedad enfermedad;
    private Paciente paciente;
}
