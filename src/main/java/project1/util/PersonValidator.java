package project1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import project1.models.Person;
import project1.repositories.PersonRepository;

@Component
public class PersonValidator implements Validator {
    private final PersonRepository personRepository;

    @Autowired
    public PersonValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (personRepository.findPersonByFullName(person.getFullName()).isPresent())
            errors.rejectValue("fullName", "", "Person with this full name already exists");
    }
}
