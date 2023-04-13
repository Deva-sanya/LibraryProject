package project1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project1.models.Person;
import project1.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PersonRepository personRepository;

    @Autowired
    public PeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAllPeople() {
        return personRepository.findAll();
    }

    public Person findPersonById(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void updatePerson(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }

}
