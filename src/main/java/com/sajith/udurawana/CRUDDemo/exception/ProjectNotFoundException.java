package com.sajith.udurawana.CRUDDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception indicating that a project was not found.
 * This exception is annotated with @ResponseStatus to return a 404 NOT_FOUND
 * status code.
 * 
 * @param message The message indicating the cause of the exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
