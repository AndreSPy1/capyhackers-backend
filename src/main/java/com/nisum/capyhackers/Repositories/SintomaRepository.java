package com.nisum.capyhackers.Repositories;

import com.nisum.capyhackers.models.Sintoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SintomaRepository extends JpaRepository<Sintoma, Integer> {
}
