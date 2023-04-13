package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project1.models.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findPersonByFullName(String fullName);
}
