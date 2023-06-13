package com.nisum.capyhackers.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PacienteRequestDTO {
    private String nombrePaciente;
    private String generoPaciente;
    private String fechaNacimiento;
}
