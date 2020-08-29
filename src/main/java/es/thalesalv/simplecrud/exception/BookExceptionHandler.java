package es.thalesalv.simplecrud.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import es.thalesalv.simplecrud.model.ErrorResponse;

@ControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<?> resourceNotFoundException(BookNotFound ex, WebRequest request) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .dateTime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .errorMessage(ex.getMessage()).build(), 
            HttpStatus.NOT_FOUND);
    }
}