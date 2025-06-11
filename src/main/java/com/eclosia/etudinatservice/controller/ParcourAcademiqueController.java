package com.eclosia.etudinatservice.controller;

import com.eclosia.etudinatservice.dto.ParcourAcademiqueDto;
import com.eclosia.etudinatservice.service.ParcourAcademiqueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/etudiants/{etudiantId}/parcours-academiques")
@RequiredArgsConstructor
@Tag(name = "Parcours Académiques", description = "Gestion des parcours académiques des étudiants")
public class ParcourAcademiqueController {

  private final ParcourAcademiqueService parcourAcademiqueService;

  @GetMapping
  @Operation(summary = "Récupérer tous les parcours académiques d'un étudiant")
  public Flux<ParcourAcademiqueDto> getParcours(@PathVariable Long etudiantId) {
    return parcourAcademiqueService.getParcoursByEtudiantId(etudiantId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Ajouter un nouveau parcours académique")
  public Mono<ParcourAcademiqueDto> createParcour(
     @PathVariable Long etudiantId,
     @Valid @RequestBody ParcourAcademiqueDto parcourDto) {
    return parcourAcademiqueService.createParcour(etudiantId, parcourDto);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Modifier un parcours académique")
  public Mono<ParcourAcademiqueDto> updateParcour(
     @PathVariable Long etudiantId,
     @PathVariable Long id,
     @Valid @RequestBody ParcourAcademiqueDto parcourDto) {
    return parcourAcademiqueService.updateParcour(id, etudiantId, parcourDto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Supprimer un parcours académique")
  public Mono<Void> deleteParcour(
     @PathVariable Long etudiantId,
     @PathVariable Long id) {
    return parcourAcademiqueService.deleteParcour(id, etudiantId);
  }
}
