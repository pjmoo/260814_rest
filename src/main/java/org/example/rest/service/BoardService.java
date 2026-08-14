package org.example.rest.service;

import lombok.RequiredArgsConstructor;
import org.example.rest.domain.entity.BoardEntity;
import org.example.rest.domain.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;

    // Create
    @Transactional
    public BoardEntity create(BoardEntity boardEntity) {
        return boardRepository.save(boardEntity);
    }

    // Read (all)
    public List<BoardEntity> readAll() {
        return boardRepository.findAll();
    }

    // Read (one)
    public BoardEntity readOne(UUID uuid) {
        return boardRepository.findByUuid(uuid).orElseThrow();
    }
}
