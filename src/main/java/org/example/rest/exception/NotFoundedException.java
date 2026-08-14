package org.example.rest.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundedException extends RuntimeException {
    public NotFoundedException(String message) {
        super(message);
    }
}
