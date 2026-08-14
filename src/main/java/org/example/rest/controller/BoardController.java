package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.rest.domain.entity.BoardEntity;
import org.example.rest.dto.BoardRequestDTO;
import org.example.rest.dto.BoardResponseDTO;
import org.example.rest.service.BoardService;
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
    public BoardResponseDTO create(@RequestBody BoardRequestDTO boardRequestDTO) {
        BoardEntity boardEntity = boardRequestDTO.toEntity();
        BoardEntity saved = boardService.create(boardEntity);
        return BoardResponseDTO.fromEntity(saved);
    }

    @GetMapping
    public List<BoardResponseDTO> readAll() {
        List<BoardEntity> boards = boardService.readAll();
        return boards.stream()
                .map(BoardResponseDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{uuid}")
    public BoardResponseDTO readOne(@PathVariable UUID uuid) {
        BoardEntity boardEntity = boardService.readOne(uuid);
        return BoardResponseDTO.fromEntity(boardEntity);
    }
}
