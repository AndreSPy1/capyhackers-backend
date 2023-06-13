package com.nisum.capyhackers.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reporte_sintoma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReporteSintoma implements Serializable {
    @Id
    @Column(name = "id_reporte_sintoma", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReporteSintoma;

    @Column(name = "porcentual_sintoma")
    private Integer porcentualSintoma;

    @Column(name = "fecha_reporte_sintoma")
    private Date fechaReporteSintoma;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_sintoma", nullable = false)
    private Sintoma sintoma;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_paciente", nullable = false)
    private Paciente paciente;
}
