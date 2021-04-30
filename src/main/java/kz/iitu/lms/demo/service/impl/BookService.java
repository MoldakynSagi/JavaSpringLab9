package kz.iitu.lms.demo.service.impl;


import kz.iitu.lms.demo.model.Book;
import kz.iitu.lms.demo.repository.BookRepository;
import kz.iitu.lms.demo.service.iBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements iBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book create(Book o) {
        return bookRepository.save(o);
    }

    @Override
    public Book update(Book o) {
        return bookRepository.save(o);
    }

    @Override
    public void delete(Long o) {
        bookRepository.delete(getById(o));
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAllByName(String name) {
        return bookRepository.getByNameContaining(name);
    }

    @Override
    public List<Book> getAllByDesc(String info) {
        return bookRepository.getAllByInfoContaining(info);
    }

    @Override
    public List<Book> getAllByAuthor(Long authorId) {
        return bookRepository.getAllByAuthorId(authorId);
    }
}
