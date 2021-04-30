package kz.iitu.lms.demo.service;


import kz.iitu.lms.demo.model.Userbooks;

import java.util.List;

public interface iUserBookService {
    Userbooks create(Userbooks o);
    Userbooks update(Userbooks o);
    void deleteById(Long id);
    Userbooks getById(Long id);
    List<Userbooks> getAll();
    List<Userbooks> getAllByUser(Long userId);
    List<Userbooks> getAllByBook(Long bookId);
}
