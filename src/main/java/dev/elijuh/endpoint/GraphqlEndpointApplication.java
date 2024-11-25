package dev.elijuh.endpoint;

import dev.elijuh.endpoint.entity.Author;
import dev.elijuh.endpoint.entity.Book;
import dev.elijuh.endpoint.repository.AuthorRepository;
import dev.elijuh.endpoint.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphqlEndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlEndpointApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			Author billy = authorRepository.save(new Author("Billy"));
			Author bobby = authorRepository.save(new Author("Bobby"));

			bookRepository.saveAll(List.of(
				Book.builder().title("The Java Language").pageCount(500).author(billy).build(),
				Book.builder().title("Everything About GraphQL").pageCount(200).author(bobby).build()
			));
		};
	}

}
