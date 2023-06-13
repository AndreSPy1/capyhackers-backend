package com.nisum.capyhackers.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paciente implements Serializable {
    @Id
    @Column(name = "id_paciente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @Column(name = "nombre_paciente", length = 50)
    private String nombrePaciente;

    @Column(name = "genero_paciente", length = 50)
    private String generoPaciente;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
}
