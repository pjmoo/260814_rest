package org.example.rest.domain.repository;

import org.example.rest.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    Optional<BoardEntity> findByUuid(UUID uuid);
}
