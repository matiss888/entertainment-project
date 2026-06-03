package com.matiss.entertainment_storage.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MediaItemRequestDTO {

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