package project1.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;


    @Column(name = "fullName")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String fullName;

    @Column(name = "yearOfBirth")
    @Positive(message = "Year should not be negative")
    @Min(value = 1900, message = "Year should be more then 1900")
    private int yearOfBirth;

    public Person() {

    }

}
