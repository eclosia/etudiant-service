package com.eclosia.etudinatservice.repository;

import com.eclosia.etudinatservice.entity.ParcourAcademique;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ParcourAcademiqueRepository extends R2dbcRepository<ParcourAcademique, Long> {
  Flux<ParcourAcademique> findByEtudiantId(Long etudiantId);
}
