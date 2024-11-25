package dev.elijuh.endpoint.repository;


import dev.elijuh.endpoint.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author elijuh
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
