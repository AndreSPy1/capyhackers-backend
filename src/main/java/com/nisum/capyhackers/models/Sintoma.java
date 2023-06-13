package com.nisum.capyhackers.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "sintoma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sintoma implements Serializable {
    @Id
    @Column(name = "id_sintoma", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSintoma;

    @Column(name = "nombre_sintoma", length = 150)
    private String nombreSintoma;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_enfermedad", nullable = false)
    private Enfermedad enfermedad;
}
