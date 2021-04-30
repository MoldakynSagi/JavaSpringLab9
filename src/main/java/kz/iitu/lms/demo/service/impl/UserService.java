package kz.iitu.lms.demo.service.impl;


import kz.iitu.lms.demo.model.User;
import kz.iitu.lms.demo.repository.UserRepository;
import kz.iitu.lms.demo.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements iUserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User createUser(User o) {
        o.setPassword(passwordEncoder.encode(o.getPassword()));
         return userRepository.saveAndFlush(o);
    }

    @Override
    public User update(User o) {
        o.setPassword(passwordEncoder.encode(o.getPassword()));
        return userRepository.save(o);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.delete(getById(id));
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllByName(String name) {
        return userRepository.getAllByFullNameContaining(name);
    }

//    @Override
//    public void createUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.saveAndFlush(user);
//    }

    @Override
    public void updateUser(Long id, User user) {
        User userDb = userRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setUsername(user.getUsername());
            userDb.setPassword(user.getPassword()); // plaintext password

            userRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }
        return user;
    }
}
