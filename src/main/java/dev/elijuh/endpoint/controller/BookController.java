package dev.elijuh.endpoint.controller;


import dev.elijuh.endpoint.entity.Author;
import dev.elijuh.endpoint.entity.Book;
import dev.elijuh.endpoint.repository.AuthorRepository;
import dev.elijuh.endpoint.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

/**
 * @author elijuh
 */
@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @QueryMapping
    public Iterable<Book> books() {
        return bookRepository.findAll();
    }

    @MutationMapping
    public Book addBook(@Argument BookInput bookInput) {
        Author author = authorRepository.findById(bookInput.authorId)
            .orElseThrow(() -> new IllegalArgumentException("no author exists with id " + bookInput.authorId));

        Book book = Book.builder()
            .title(bookInput.title)
            .publisher(bookInput.publisher)
            .pageCount(bookInput.pageCount)
            .author(author)
            .build();

        return bookRepository.save(book);
    }

    @MutationMapping
    public Book reassignAuthor(@Argument Long bookId, @Argument Long authorId) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new IllegalArgumentException("no book exists with id " + bookId));

        Author author = authorRepository.findById(authorId)
            .orElseThrow(() -> new IllegalArgumentException("no author exists with id " + authorId));

        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public record BookInput(String title, String publisher, Integer pageCount, Long authorId) {}
}
