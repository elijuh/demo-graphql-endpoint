package dev.elijuh.endpoint.entity;


import jakarta.persistence.*;
import lombok.*;

/**
 * @author elijuh
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title, publisher;
    private Integer pageCount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
}
