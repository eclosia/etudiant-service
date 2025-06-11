package com.eclosia.etudinatservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompetenceDto {

  private Long id;

  @NotBlank(message = "Le nom de la compétence est obligatoire")
  private String nom;

  @NotNull(message = "Le niveau est obligatoire")
  @Min(value = 0, message = "Le niveau doit être entre 0 et 100")
  @Max(value = 100, message = "Le niveau doit être entre 0 et 100")
  private Integer niveau;
}

