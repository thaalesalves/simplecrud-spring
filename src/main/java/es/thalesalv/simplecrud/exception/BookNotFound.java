package es.thalesalv.simplecrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFound extends RuntimeException {

    public BookNotFound(String message, Throwable t) {
        super(message, t);
    }

    public BookNotFound(String message) {
        super(message);
    }

    public BookNotFound() {
        super("Livro não encontrado");
    }
}