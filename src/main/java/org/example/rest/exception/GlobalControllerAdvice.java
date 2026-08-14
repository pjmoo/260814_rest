package org.example.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    // 1. try-catch -> 그거 맞는 값을 return -> 관리가 어려워요
    // 2. exception handler -> response body로 바꿔줘야함 -> ControllerAdvice => RestControllerAdvice로 쓰거나
    // Exception Handler -> RestController 안에 넣어주면 알아서 바뀜
    // handler -> ResponseEntity

    @ExceptionHandler(NotFoundedException.class)
    public ResponseEntity<String> handleNotFoundedException(NotFoundedException e) {
//        return e.getMessage();
//        return ResponseEntity.notFound().build();
        return ResponseEntity // 직접해줘야하는 구나
//                .status(404)
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}
