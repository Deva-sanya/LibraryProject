package project1.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "name")
    @NotEmpty(message = "Name of book should not be empty")
    @Size(min = 2, max = 100, message = "The title of the book should be between two and 100 characters long.")
    private String name;

    @Column(name = "author")
    @NotEmpty(message = "Author should not be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String author;

    @Column(name = "year_of_create")
    @Positive(message = "Year should not be negative")
    @Min(value = 1500, message = "Year should be more then 1500.")
    private int year;

    public Book() {

    }

}
