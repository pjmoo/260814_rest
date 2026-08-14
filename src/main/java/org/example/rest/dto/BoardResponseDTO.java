package org.example.rest.dto;

import lombok.Builder;
import org.example.rest.domain.entity.BoardEntity;

import java.time.Instant;
import java.util.UUID;

@Builder
public record BoardResponseDTO(
        UUID uuid,
        String title, String content,
        Instant createdAt, Instant updatedAt
) {
    public static BoardResponseDTO fromEntity(BoardEntity boardEntity) {
        return BoardResponseDTO.builder()
                .uuid(boardEntity.getUuid())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .createdAt(boardEntity.getCreatedAt())
                .updatedAt(boardEntity.getUpdatedAt())
                .build();
    }
}