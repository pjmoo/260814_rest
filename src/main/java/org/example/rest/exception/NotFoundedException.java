package org.example.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundedException extends RuntimeException {
    public NotFoundedException(String message) {
        super(message);
    }
}
