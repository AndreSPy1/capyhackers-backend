package com.nisum.capyhackers.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReporteSintomaRequestDTO {
    private Integer porcentualSintoma;
    private Integer idSintoma;
    private Integer idPaciente;
}
