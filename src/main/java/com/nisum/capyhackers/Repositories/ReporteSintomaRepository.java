package com.nisum.capyhackers.Repositories;

import com.nisum.capyhackers.models.ReporteSintoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteSintomaRepository extends JpaRepository<ReporteSintoma, Integer> {

}
