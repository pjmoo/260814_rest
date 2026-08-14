package org.example.rest.dto;

import org.example.rest.domain.entity.BoardEntity;

public record BoardRequestDTO(String title, String content) {
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .build();
    }
}