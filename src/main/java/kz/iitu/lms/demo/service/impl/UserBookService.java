package kz.iitu.lms.demo.service.impl;


import kz.iitu.lms.demo.model.Userbooks;
import kz.iitu.lms.demo.repository.UserBookRepository;
import kz.iitu.lms.demo.service.iUserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookService implements iUserBookService {

    @Autowired
    private UserBookRepository userBookRepository;

    @Override
    public Userbooks create(Userbooks o) {
        return userBookRepository.save(o);
    }

    @Override
    public Userbooks update(Userbooks o) {
        return userBookRepository.save(o);
    }

    @Override
    public void deleteById(Long id) {
        userBookRepository.deleteById(id);
    }

    @Override
    public Userbooks getById(Long id) {
        return userBookRepository.getById(id);
    }

    @Override
    public List<Userbooks> getAll() {
        return userBookRepository.findAll();
    }

    @Override
    public List<Userbooks> getAllByUser(Long userId) {
        return userBookRepository.getAllByUserId(userId);
    }

    @Override
    public List<Userbooks> getAllByBook(Long bookId) {
        return userBookRepository.getAllByBookId(bookId);
    }
}
