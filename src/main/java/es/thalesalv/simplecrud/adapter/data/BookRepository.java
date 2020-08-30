package es.thalesalv.simplecrud.adapter.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.thalesalv.simplecrud.adapter.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}