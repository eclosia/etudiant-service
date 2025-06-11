package com.eclosia.etudinatservice.repository;

import com.eclosia.etudinatservice.entity.Competence;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CompetenceRepository extends R2dbcRepository<Competence, Long> {
  Flux<Competence> findByEtudiantId(Long etudiantId);
}