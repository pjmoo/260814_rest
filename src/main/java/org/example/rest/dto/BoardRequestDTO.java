package org.example.rest.dto;

import jakarta.validation.constraints.NotBlank;
import org.example.rest.domain.entity.BoardEntity;

public record BoardRequestDTO(
        @NotBlank String title,
        @NotBlank String content) {
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .build();
    }
}