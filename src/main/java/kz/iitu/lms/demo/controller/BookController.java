package kz.iitu.lms.demo.controller;

import io.swagger.annotations.Api;

import kz.iitu.lms.demo.model.Book;
import kz.iitu.lms.demo.service.iBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Api(value = "User Controller class", description = "This class allows to interact with User object")
public class BookController {

    @Autowired
    private kz.iitu.lms.demo.service.iBookService iBookService;

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return iBookService.getById(id);
    }

    @PostMapping("/create")
    public Book create(@RequestBody Book o){
        return iBookService.create(o);
    }

    @PostMapping("/update")
    public Book update(@RequestBody Book o){
        return iBookService.update(o);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        iBookService.delete(id);
    }

    @GetMapping("/all")
    public List<Book> getAll(){
       return iBookService.getAll();
    }

    @GetMapping("/allByName")
    public List<Book> getAllByName(@Param(value = "name") String name){
       return iBookService.getAllByName(name);
    }

    @GetMapping("/BYdesc")
    public List<Book> getAllByDesc(@Param(value = "info") String info){
       return iBookService.getAllByDesc(info);
    }

    @GetMapping("/BYauthor")
    public List<Book> getAllByAuthor(@Param(value = "id") Long id){
       return iBookService.getAllByAuthor(id);
    }
}

