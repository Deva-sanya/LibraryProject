package project1.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String fullName;

    @Positive(message = "Year should not be negative")
    @Min(value = 1900, message = "Year should be more then 1900")
    private int yearOfBirth;

    public Person() {

    }

}
