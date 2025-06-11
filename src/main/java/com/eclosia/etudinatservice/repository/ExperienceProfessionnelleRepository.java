package com.eclosia.etudinatservice.repository;

import com.eclosia.etudinatservice.entity.ExperienceProfessionnelle;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ExperienceProfessionnelleRepository extends R2dbcRepository<ExperienceProfessionnelle, Long> {
  Flux<ExperienceProfessionnelle> findByEtudiantId(Long etudiantId);
}
