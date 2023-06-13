package com.nisum.capyhackers.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "enfermedad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enfermedad implements Serializable {
    @Id
    @Column(name = "id_enfermedad", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnfermedad;

    @Column(name = "nombre_enfermedad", length = 50)
    private String nombreEnfermedad;
}
