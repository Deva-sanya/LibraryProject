package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import project1.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findBookByNameStartsWith(@Param("name")String name);
}
