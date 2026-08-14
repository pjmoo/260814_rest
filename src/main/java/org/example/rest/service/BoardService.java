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

    // Update
    @Transactional
    public BoardEntity update(UUID uuid, BoardEntity boardEntity) {
        BoardEntity entity = readOne(uuid); // 없으면 에러 나옴
        entity.update(boardEntity);
        return entity;
    }

    // Update Title
    @Transactional
    public BoardEntity updateTitle(UUID uuid, String title) {
        BoardEntity entity = readOne(uuid); // 없으면 에러 나옴
        entity.updateTitle(title);
        return entity;
    }

    // Delete
    @Transactional
    public void delete(UUID uuid) {
        BoardEntity entity = readOne(uuid); // 없을 때 에러처리
        boardRepository.delete(entity);
    }
}
