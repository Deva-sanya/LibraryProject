package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project1.models.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBooksById(int id);
    List<Book> findAllByOrderByYearDesc();
}
