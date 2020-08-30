package es.thalesalv.simplecrud.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String author;
    private String bookTitle;
    private int publishYear;
    private String publisher;
}