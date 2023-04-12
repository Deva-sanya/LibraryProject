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
public class BookDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Book> getAllBook() {

        Session session = sessionFactory.getCurrentSession();

        List<Book> books = session.createQuery("select b from Book b", Book.class).
                getResultList();

        return books;
    }

    public Book findBookById(int id) {
        return null;
    }


    public void saveBook(Book book) {
    }

    public void updateBook(int id, Book updatedBook) {
    }

    public void deleteBook(int id) {
    }

    public Optional<Person> getBookOwner(int id) {
        return null;
    }

    public void release(int id) {
    }

    public void assign(int id, Person selectedPerson) {

    }

}
