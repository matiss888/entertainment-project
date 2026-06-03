package com.matiss.entertainment_storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MediaItemResponseDTO {
    private Long id;
    private String title;
    private String type;
    private String genre;
    private Double rating;
    private String status;
}