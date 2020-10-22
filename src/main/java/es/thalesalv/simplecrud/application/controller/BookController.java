package es.thalesalv.simplecrud.application.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.thalesalv.simplecrud.adapter.data.BookRepository;
import es.thalesalv.simplecrud.adapter.model.BookEntity;
import es.thalesalv.simplecrud.application.exception.BookNotFoundException;
import es.thalesalv.simplecrud.application.model.BookDTO;
import es.thalesalv.simplecrud.application.util.MessageConstants;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {

    private final MessageConstants constants;
    private final BookRepository repo;

    @GetMapping
    public Map<String, String> olaMundo() throws UnknownHostException {
        Map<String, String> map = new HashMap<>();
        map.put(constants.messageKey(), constants.helloWorld());
        map.put(constants.openshiftKey(), constants.openshiftValue());
        map.put(constants.messageForEveryoneKey(), constants.messageForEveryoneValue());
        map.put(constants.languageKey(), constants.languageValue());
        map.put(constants.profileKey(), constants.profileValue());
        map.put("hostname", InetAddress.getLocalHost().getHostName());
        map.put(constants.databaseKey(), constants.databaseValue());

        return map;
    }

    @GetMapping("/get")
    public List<BookEntity> getAllBooks() {
        return repo.findAll();
    }

    @GetMapping("/get/{id}")
    public BookEntity getBookById(@PathVariable(value = "id") Long bookId) {
        return repo.findById(bookId).orElseThrow(() -> new BookNotFoundException(constants.bookNotFoundMessage() + bookId));
    }

    @PostMapping("/add")
    public BookEntity insertBook(@RequestBody BookDTO book) {

        BookEntity entity = BookEntity.builder()
                .author(book.getAuthor())
                .bookTitle(book.getBookTitle())
                .publishYear(book.getPublishYear())
                .publisher(book.getPublisher())
                .build();

        return repo.save(entity);
    }

    @PutMapping("/update/{id}")
    public BookEntity updateBook(@PathVariable(value = "id") Long bookId, @RequestBody BookDTO book) {

        BookEntity entity = BookEntity.builder()
                .id(bookId)
                .author(book.getAuthor())
                .bookTitle(book.getBookTitle())
                .publishYear(book.getPublishYear())
                .publisher(book.getPublisher())
                .build();
                
        return repo.save(entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long bookId) {
        BookEntity book = repo.findById(bookId).orElseThrow(() -> new BookNotFoundException(constants.bookNotFoundMessage() + bookId));
        book.setId(bookId);
        repo.delete(book);
        return "{ \"deleted\": true }";
    }
}