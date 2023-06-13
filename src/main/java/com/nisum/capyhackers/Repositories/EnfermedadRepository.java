package com.nisum.capyhackers.Repositories;

import com.nisum.capyhackers.models.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermedadRepository extends JpaRepository<Enfermedad, Integer> {

}
