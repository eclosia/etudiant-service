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
public class ExperienceProfessionnelleDto {

  private Long id;

  @NotBlank(message = "Le titre est obligatoire")
  private String titre;

  @NotBlank(message = "L'entreprise est obligatoire")
  private String entreprise;

  @NotBlank(message = "La période est obligatoire")
  private String periode;

  @NotBlank(message = "Le type est obligatoire")
  private String type;

  private String description;
}

