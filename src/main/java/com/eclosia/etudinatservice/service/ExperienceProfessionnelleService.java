package com.eclosia.etudinatservice.service;

import com.eclosia.etudinatservice.dto.ExperienceProfessionnelleDto;
import com.eclosia.etudinatservice.entity.ExperienceProfessionnelle;
import com.eclosia.etudinatservice.repository.ExperienceProfessionnelleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExperienceProfessionnelleService {

  private final ExperienceProfessionnelleRepository experienceRepository;

  public Flux<ExperienceProfessionnelleDto> getExperiencesByEtudiantId(Long etudiantId) {
    return experienceRepository.findByEtudiantId(etudiantId)
       .map(this::toDto);
  }

  public Mono<ExperienceProfessionnelleDto> createExperience(Long etudiantId, ExperienceProfessionnelleDto experienceDto) {
    ExperienceProfessionnelle experience = ExperienceProfessionnelle.builder()
       .etudiantId(etudiantId)
       .titre(experienceDto.getTitre())
       .entreprise(experienceDto.getEntreprise())
       .periode(experienceDto.getPeriode())
       .type(experienceDto.getType())
       .description(experienceDto.getDescription())
       .build();

    return experienceRepository.save(experience)
       .map(this::toDto);
  }

  public Mono<ExperienceProfessionnelleDto> updateExperience(Long id, Long etudiantId, ExperienceProfessionnelleDto experienceDto) {
    return experienceRepository.findById(id)
       .filter(experience -> experience.getEtudiantId().equals(etudiantId))
       .flatMap(existingExperience -> {
         existingExperience.setTitre(experienceDto.getTitre());
         existingExperience.setEntreprise(experienceDto.getEntreprise());
         existingExperience.setPeriode(experienceDto.getPeriode());
         existingExperience.setType(experienceDto.getType());
         existingExperience.setDescription(experienceDto.getDescription());
         return experienceRepository.save(existingExperience);
       })
       .map(this::toDto);
  }

  public Mono<Void> deleteExperience(Long id, Long etudiantId) {
    return experienceRepository.findById(id)
       .filter(experience -> experience.getEtudiantId().equals(etudiantId))
       .flatMap(experienceRepository::delete);
  }

  private ExperienceProfessionnelleDto toDto(ExperienceProfessionnelle experience) {
    return ExperienceProfessionnelleDto.builder()
       .id(experience.getId())
       .titre(experience.getTitre())
       .entreprise(experience.getEntreprise())
       .periode(experience.getPeriode())
       .type(experience.getType())
       .description(experience.getDescription())
       .build();
  }
}

