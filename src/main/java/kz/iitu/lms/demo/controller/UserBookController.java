package kz.iitu.lms.demo.controller;

import io.swagger.annotations.Api;

import kz.iitu.lms.demo.model.Userbooks;
import kz.iitu.lms.demo.service.iUserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userbooks")
@Api(value = "UserBooks Controller class", description = "This class allows to interact with UserBook object")
public class UserBookController {

    @Autowired
    private kz.iitu.lms.demo.service.iUserBookService iUserBookService;

    @PostMapping("/create")
    public Userbooks create(@RequestBody Userbooks o){
        return iUserBookService.create(o);
    }

    @PutMapping("/update")
    public Userbooks update(@RequestBody Userbooks o){
        return iUserBookService.update(o);
    }

    @GetMapping("/{id}")
    public Userbooks get(@PathVariable Long id){
        return iUserBookService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
         iUserBookService.deleteById(id);
    }

    @GetMapping("/all")
    public List<Userbooks> getAll(){
        return iUserBookService.getAll();
    }

    @GetMapping("/allByUser")
    public List<Userbooks> getAllByUser(@Param(value = "id") Long id){
        return iUserBookService.getAllByUser(id);
    }

    @GetMapping("/bookById")
    public List<Userbooks> getAllByBook(@Param(value = "id") Long id){
        return iUserBookService.getAllByBook(id);
    }
}


