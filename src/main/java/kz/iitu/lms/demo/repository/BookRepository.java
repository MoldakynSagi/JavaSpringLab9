package kz.iitu.lms.demo.repository;

import kz.iitu.lms.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book getById(Long id);
    List<Book> getByNameContaining(String name);
    List<Book> getAllByInfoContaining(String info);
    List<Book> getAllByAuthorId(Long authorId);
}
