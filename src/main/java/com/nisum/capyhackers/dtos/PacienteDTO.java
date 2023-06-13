package com.nisum.capyhackers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PacienteDTO {
    private Integer idPaciente;
    private String nombrePaciente;
    private String generoPaciente;
    private Date fechaNacimiento;
}
