package com.nisum.capyhackers.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reporte_enfermedad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReporteEnfermedad implements Serializable {
    @Id
    @Column(name = "id_reporte_enfermedad", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReporteEnfermedad;

    @Column(name = "fecha_reporte_enfermedad")
    private Date fechaReporteEnfermedad;

    @Column(name = "porcentual_total")
    private Integer porcentualTotal;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_enfermedad", nullable = false)
    private Enfermedad enfermedad;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_paciente", nullable = false)
    private Paciente paciente;
}
