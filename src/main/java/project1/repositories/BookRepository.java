package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project1.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
