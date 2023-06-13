package com.nisum.capyhackers.Repositories;

import com.nisum.capyhackers.models.ReporteEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteEnfermedadRepository extends JpaRepository<ReporteEnfermedad, Integer> {

}
