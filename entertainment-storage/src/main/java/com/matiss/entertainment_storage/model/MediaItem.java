package com.matiss.entertainment_storage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Table(name = "media_items")
@NoArgsConstructor
@AllArgsConstructor
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String type;
    @NotBlank
    private String genre;
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double rating;
    @NotBlank
    private String status;

}
