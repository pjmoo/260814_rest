package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.rest.domain.entity.BoardEntity;
import org.example.rest.dto.BoardRequestDTO;
import org.example.rest.dto.BoardResponseDTO;
import org.example.rest.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@Controller // return시 뷰 이름이나 ModelAndView 등을 통해서 뷰 리졸버 처리를 지시
@RestController // -> ResponseBody를 알아서 붙여준다
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
//    public String create(@ModelAttribute BoardEntity boardEntity) {
//        return "redirect:/";
//    }
//    @ResponseBody // view resolver를 통하지 않고 직접 json 등의 형태로 데이터를 줌
//    public BoardResponseDTO create(@RequestBody BoardRequestDTO boardRequestDTO) {
    public ResponseEntity<BoardResponseDTO> create(@RequestBody BoardRequestDTO boardRequestDTO) {
        BoardEntity boardEntity = boardRequestDTO.toEntity();
        BoardEntity saved = boardService.create(boardEntity);
//        return BoardResponseDTO.fromEntity(saved);
//        return ResponseEntity.created() // 201 URI?
        return ResponseEntity
//                .status(201)
                .status(HttpStatus.CREATED) // 201
                .body(BoardResponseDTO.fromEntity(saved));
    }

//    @GetMapping
//    public List<BoardResponseDTO> readAll() {
//        List<BoardEntity> boards = boardService.readAll();
//        return boards.stream()
//                .map(BoardResponseDTO::fromEntity)
//                .toList();
//    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDTO>> readAll() {
        List<BoardEntity> boards = boardService.readAll();

//        return ResponseEntity.status(HttpStatus.OK) // 200
        return ResponseEntity
                .ok(boards.stream()
                        .map(BoardResponseDTO::fromEntity)
                        .toList());
    }

//    @GetMapping("/{uuid}")
//    // long의 main id를 받아도 상관없는데... ResponseDTO를 통해서 uuid만 노출하기로 (이 실습에선 결정)
//    public BoardResponseDTO readOne(@PathVariable UUID uuid) {
//        BoardEntity boardEntity = boardService.readOne(uuid);
//        return BoardResponseDTO.fromEntity(boardEntity);
//    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BoardResponseDTO> readOne(@PathVariable UUID uuid) {
        BoardEntity boardEntity = boardService.readOne(uuid);
        return ResponseEntity.ok(BoardResponseDTO.fromEntity(boardEntity));
    }

//    @PutMapping("/{uuid}")
//    public BoardResponseDTO update(
//            @PathVariable UUID uuid,
//            @RequestBody BoardRequestDTO boardRequestDTO) {
//        // title, content를 한 번에 수정해줄 수 있는 형태
//        BoardEntity updated = boardService.update(uuid, boardRequestDTO.toEntity());
//        return BoardResponseDTO.fromEntity(updated);
//    }

//    @PatchMapping("/{uuid}/title")
//    public BoardResponseDTO updateTitle(
//            @PathVariable UUID uuid,
//            @RequestParam String title) {
//        BoardEntity updated = boardService.updateTitle(uuid, title);
//        return BoardResponseDTO.fromEntity(updated);
//    }


    @PutMapping("/{uuid}")
    public ResponseEntity<BoardResponseDTO> update(
            @PathVariable UUID uuid,
            @RequestBody BoardRequestDTO boardRequestDTO) {
        BoardEntity updated = boardService.update(uuid, boardRequestDTO.toEntity());
        return ResponseEntity.ok(BoardResponseDTO.fromEntity(updated));
    }

    @PatchMapping("/{uuid}/title")
    public ResponseEntity<BoardResponseDTO> updateTitle(
            @PathVariable UUID uuid,
            @RequestParam String title) {
        BoardEntity updated = boardService.updateTitle(uuid, title);
        return ResponseEntity.ok(BoardResponseDTO.fromEntity(updated));
    }

//    @DeleteMapping("/{uuid}")
//    public void delete(@PathVariable UUID uuid) {
//        boardService.delete(uuid);
//    }

    @DeleteMapping("/{uuid}")
    // Generic으로 표현해야하므로 비어있다는 void X. Wrapper Void
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        boardService.delete(uuid);
        return ResponseEntity.noContent().build();
    }
}
