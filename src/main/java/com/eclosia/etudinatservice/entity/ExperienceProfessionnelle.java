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
@Table("experiences_professionnelles")
public class ExperienceProfessionnelle {

  @Id
  private Long id;

  @NotNull
  private Long etudiantId;

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
