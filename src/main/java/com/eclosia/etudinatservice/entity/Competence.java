package com.eclosia.etudinatservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("competences")
public class Competence {

  @Id
  private Long id;

  @NotNull
  private Long etudiantId;

  @NotBlank(message = "Le nom de la compétence est obligatoire")
  private String nom;

  @NotNull(message = "Le niveau est obligatoire")
  @Min(value = 0, message = "Le niveau doit être entre 0 et 100")
  @Max(value = 100, message = "Le niveau doit être entre 0 et 100")
  private Integer niveau; // Pourcentage de 0 à 100
}
