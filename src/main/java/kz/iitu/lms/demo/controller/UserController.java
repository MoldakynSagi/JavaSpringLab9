package kz.iitu.lms.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.iitu.lms.demo.model.User;
import kz.iitu.lms.demo.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User Controller class", description = "This class allows to interact with User object")
public class UserController {

    @Autowired
    private kz.iitu.lms.demo.service.iUserService iUserService;

    @GetMapping("/users/{id}")
    public User get(@PathVariable Long id) {
        return iUserService.getById(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User o){
       return iUserService.createUser(o);
    }

    @PutMapping("/update")
    public User update(@RequestBody User o){
        return iUserService.update(o);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {iUserService.deleteUserById(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Method to get list of users", response = List.class)
    public List<User> getAll() {
        return iUserService.getAll();
    }

    @GetMapping("/byName")
    public List<User> getAllByName(@Param(value = "name") String name) {
        return iUserService.getAllByName(name);
    }

}


