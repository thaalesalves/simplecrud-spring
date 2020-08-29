package es.thalesalv.simplecrud.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.thalesalv.simplecrud.data.BookRepository;
import es.thalesalv.simplecrud.exception.BookNotFound;
import es.thalesalv.simplecrud.model.Book;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookRepository repo;

    @GetMapping
    public String olaMundo() throws BookNotFound {
        return "Olá, mundo!";
    }

    @GetMapping("/get")
    public List<Book> getAllBooks() throws BookNotFound {
        return repo.findAll();
    }

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) throws BookNotFound {
        return repo.findById(bookId).orElseThrow(() -> new BookNotFound("Livro não encontrado :: " + bookId));
    }

    @PostMapping("/add")
    public Book insertBook(@RequestBody Book book) throws BookNotFound {
        return repo.save(book);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId, @RequestBody Book book) throws BookNotFound {
        repo.findById(bookId).orElseThrow(() -> new BookNotFound("Livro não encontrado :: " + bookId));
        book.setId(bookId);
        return repo.save(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long bookId) throws BookNotFound {
        repo.findById(bookId).orElseThrow(() -> new BookNotFound("Livro não encontrado :: " + bookId));
        Book book = new Book();
        book.setId(bookId);
        repo.delete(book);
        return "{ \"deleted\": true }";
    }
}