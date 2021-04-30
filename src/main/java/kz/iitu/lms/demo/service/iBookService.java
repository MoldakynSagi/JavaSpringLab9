package kz.iitu.lms.demo.service;



import kz.iitu.lms.demo.model.Book;

import java.util.List;

public interface iBookService {
    Book create(Book o);
    Book update(Book o);
    void delete(Long o);
    Book getById(Long id);
    List<Book> getAll();
    List<Book> getAllByName(String name);
    List<Book> getAllByDesc(String desc);
    List<Book> getAllByAuthor(Long author_id);
}
