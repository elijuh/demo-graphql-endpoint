package dev.elijuh.endpoint.controller;


import dev.elijuh.endpoint.entity.Author;
import dev.elijuh.endpoint.repository.AuthorRepository;
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
public class AuthorController {
    private final AuthorRepository authorRepository;

    @QueryMapping
    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    public Optional<Author> authorById(@Argument Long id) {
        return authorRepository.findById(id);
    }

    @MutationMapping
    public Author addAuthor(@Argument AuthorInput authorInput) {
        Author author = new Author(authorInput.name);
        return authorRepository.save(author);
    }

    public record AuthorInput(String name) {}
}
