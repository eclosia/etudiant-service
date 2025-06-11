package com.eclosia.etudinatservice.service;

import com.eclosia.etudinatservice.dto.CompetenceDto;
import com.eclosia.etudinatservice.entity.Competence;
import com.eclosia.etudinatservice.repository.CompetenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CompetenceService {

  private final CompetenceRepository competenceRepository;

  public Flux<CompetenceDto> getCompetencesByEtudiantId(Long etudiantId) {
    return competenceRepository.findByEtudiantId(etudiantId)
       .map(this::toDto);
  }

  public Mono<CompetenceDto> createCompetence(Long etudiantId, CompetenceDto competenceDto) {
    Competence competence = Competence.builder()
       .etudiantId(etudiantId)
       .nom(competenceDto.getNom())
       .niveau(competenceDto.getNiveau())
       .build();

    return competenceRepository.save(competence)
       .map(this::toDto);
  }

  public Mono<CompetenceDto> updateCompetence(Long id, Long etudiantId, CompetenceDto competenceDto) {
    return competenceRepository.findById(id)
       .filter(competence -> competence.getEtudiantId().equals(etudiantId))
       .flatMap(existingCompetence -> {
         existingCompetence.setNom(competenceDto.getNom());
         existingCompetence.setNiveau(competenceDto.getNiveau());
         return competenceRepository.save(existingCompetence);
       })
       .map(this::toDto);
  }

  public Mono<Void> deleteCompetence(Long id, Long etudiantId) {
    return competenceRepository.findById(id)
       .filter(competence -> competence.getEtudiantId().equals(etudiantId))
       .flatMap(competenceRepository::delete);
  }

  private CompetenceDto toDto(Competence competence) {
    return CompetenceDto.builder()
       .id(competence.getId())
       .nom(competence.getNom())
       .niveau(competence.getNiveau())
       .build();
  }
}

