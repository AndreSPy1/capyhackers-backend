package com.nisum.capyhackers.dtos;

import com.nisum.capyhackers.models.Enfermedad;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SintomaDTO {

    private Integer idSintoma;
    private String nombreSintoma;
    private Enfermedad enfermedad;
}
