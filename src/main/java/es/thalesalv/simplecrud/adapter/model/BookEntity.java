package es.thalesalv.simplecrud.adapter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "year_published")
    private int publishYear;

    @Column(name = "publisher")
    private String publisher;
}