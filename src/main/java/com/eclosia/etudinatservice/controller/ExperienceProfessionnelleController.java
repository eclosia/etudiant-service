package com.eclosia.etudinatservice.controller;

import com.eclosia.etudinatservice.dto.ExperienceProfessionnelleDto;
import com.eclosia.etudinatservice.service.ExperienceProfessionnelleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/etudiants/{etudiantId}/experiences")

@RequiredArgsConstructor
@Tag(name = "Expériences Professionnelles", description = "Gestion des expériences professionnelles des étudiants")
public class ExperienceProfessionnelleController {

    private final ExperienceProfessionnelleService experienceService;

    @GetMapping
    @Operation(summary = "Récupérer toutes les expériences professionnelles d'un étudiant")
    public Flux<ExperienceProfessionnelleDto> getExperiences(@PathVariable Long etudiantId) {
        return experienceService.getExperiencesByEtudiantId(etudiantId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Ajouter une nouvelle expérience professionnelle")
    public Mono<ExperienceProfessionnelleDto> createExperience(
            @PathVariable Long etudiantId,
            @Valid @RequestBody ExperienceProfessionnelleDto experienceDto) {
        return experienceService.createExperience(etudiantId, experienceDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une expérience professionnelle")
    public Mono<ExperienceProfessionnelleDto> updateExperience(
            @PathVariable Long etudiantId,
            @PathVariable Long id,
            @Valid @RequestBody ExperienceProfessionnelleDto experienceDto) {
        return experienceService.updateExperience(id, etudiantId, experienceDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer une expérience professionnelle")
    public Mono<Void> deleteExperience(
            @PathVariable Long etudiantId,
            @PathVariable Long id) {
        return experienceService.deleteExperience(id, etudiantId);
    }
}

