package dev.elijuh.endpoint.repository;


import dev.elijuh.endpoint.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author elijuh
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
