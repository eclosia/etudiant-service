package com.eclosia.etudinatservice.controller;

import com.eclosia.etudinatservice.dto.CompetenceDto;
import com.eclosia.etudinatservice.service.CompetenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("http://localhost:4000")
@RequestMapping("/api/etudiants/{etudiantId}/competences")
@RequiredArgsConstructor
@Tag(name = "Compétences", description = "Gestion des compétences des étudiants")
public class CompetenceController {

    private final CompetenceService competenceService;

    @GetMapping
    @Operation(summary = "Récupérer toutes les compétences d'un étudiant")
    public Flux<CompetenceDto> getCompetences(@PathVariable Long etudiantId) {
        return competenceService.getCompetencesByEtudiantId(etudiantId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Ajouter une nouvelle compétence")
    public Mono<CompetenceDto> createCompetence(
            @PathVariable Long etudiantId,
            @Valid @RequestBody CompetenceDto competenceDto)
    {
        return competenceService.createCompetence(etudiantId, competenceDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une compétence")
    public Mono<CompetenceDto> updateCompetence(
            @PathVariable Long etudiantId,
            @PathVariable Long id,
            @Valid @RequestBody CompetenceDto competenceDto) {
        return competenceService.updateCompetence(id, etudiantId, competenceDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer une compétence")
    public Mono<Void> deleteCompetence(
            @PathVariable Long etudiantId,
            @PathVariable Long id)
    {
        return competenceService.deleteCompetence(id, etudiantId);
    }
}

