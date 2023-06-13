package com.nisum.capyhackers.dtos;

import com.nisum.capyhackers.models.Paciente;
import com.nisum.capyhackers.models.Sintoma;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReporteSintomaDTO {
    private Integer idReporteSintoma;
    private Integer porcentualSintoma;
    private Date fechaReporteSintoma;
    private Sintoma sintoma;
    private Paciente paciente;
}
