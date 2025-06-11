package com.eclosia.etudinatservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParcourAcademiqueDto {

  private Long id;

  @NotBlank(message = "Le diplôme est obligatoire")
  private String diplome;

  @NotBlank(message = "La période est obligatoire")
  private String periode;

  @NotBlank(message = "L'établissement est obligatoire")
  private String etablissement;

  @NotBlank(message = "Le lieu est obligatoire")
  private String lieu;

  private String statut; // "actuel" ou vide
}

