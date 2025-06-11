package com.eclosia.etudinatservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("parcours_academiques")
public class ParcourAcademique {

  @Id
  private Long id;

  @NotNull
  private Long etudiantId;

  @NotBlank(message = "Le diplôme est obligatoire")
  private String diplome;

  @NotBlank(message = "La période est obligatoire")
  private String periode;

  @NotBlank(message = "L'établissement est obligatoire")
  private String etablissement;

  @NotBlank(message = "Le lieu est obligatoire")
  private String lieu;

  private String statut; // "actuel" ou null/vide
}

