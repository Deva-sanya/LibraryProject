package project1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project1.models.Book;
import project1.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> getAllPerson() {
        Session session = sessionFactory.getCurrentSession();

        List<Person> people = session.createQuery("select p from Person p", Person.class).
                getResultList();


        return people;
    }

    public Person findPersonById(int id) {
        return null;
    }

    public void save(Person person) {
    }

    public void update(int id, Person updatedPerson) {
    }

    public void delete(int id) {

    }

    public Optional<Person> getPersonByFullName(String fullName) {
        return null;
    }

    public List<Book> getBooksByPersonId(int id) {
        return null;
    }
}
