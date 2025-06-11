package com.eclosia.etudinatservice.service;

import com.eclosia.etudinatservice.dto.ParcourAcademiqueDto;
import com.eclosia.etudinatservice.entity.ParcourAcademique;
import com.eclosia.etudinatservice.repository.ParcourAcademiqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ParcourAcademiqueService {

  private final ParcourAcademiqueRepository parcourAcademiqueRepository;

  public Flux<ParcourAcademiqueDto> getParcoursByEtudiantId(Long etudiantId) {
    return parcourAcademiqueRepository.findByEtudiantId(etudiantId)
       .map(this::toDto);
  }

  public Mono<ParcourAcademiqueDto> createParcour(Long etudiantId, ParcourAcademiqueDto parcourDto) {
    ParcourAcademique parcour = ParcourAcademique.builder()
       .etudiantId(etudiantId)
       .diplome(parcourDto.getDiplome())
       .periode(parcourDto.getPeriode())
       .etablissement(parcourDto.getEtablissement())
       .lieu(parcourDto.getLieu())
       .statut(parcourDto.getStatut())
       .build();

    return parcourAcademiqueRepository.save(parcour)
       .map(this::toDto);
  }

  public Mono<ParcourAcademiqueDto> updateParcour(Long id, Long etudiantId, ParcourAcademiqueDto parcourDto) {
    return parcourAcademiqueRepository.findById(id)
       .filter(parcour -> parcour.getEtudiantId().equals(etudiantId))
       .flatMap(existingParcour -> {
         existingParcour.setDiplome(parcourDto.getDiplome());
         existingParcour.setPeriode(parcourDto.getPeriode());
         existingParcour.setEtablissement(parcourDto.getEtablissement());
         existingParcour.setLieu(parcourDto.getLieu());
         existingParcour.setStatut(parcourDto.getStatut());
         return parcourAcademiqueRepository.save(existingParcour);
       })
       .map(this::toDto);
  }

  public Mono<Void> deleteParcour(Long id, Long etudiantId) {
    return parcourAcademiqueRepository.findById(id)
       .filter(parcour -> parcour.getEtudiantId().equals(etudiantId))
       .flatMap(parcourAcademiqueRepository::delete);
  }

  private ParcourAcademiqueDto toDto(ParcourAcademique parcour) {
    return ParcourAcademiqueDto.builder()
       .id(parcour.getId())
       .diplome(parcour.getDiplome())
       .periode(parcour.getPeriode())
       .etablissement(parcour.getEtablissement())
       .lieu(parcour.getLieu())
       .statut(parcour.getStatut())
       .build();
  }
}

