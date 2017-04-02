package com.simongk.controllers;

import com.simongk.entities.User;

import com.simongk.entities.UserGroup;
import com.simongk.repositories.UserGroupRepository;
import com.simongk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Szymon Gasienica-Kotelnicki
 * 2017-02-13
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository repository;
    private UserGroupRepository userGroupRepository;

    @Autowired
    public UserController(UserRepository repository,UserGroupRepository userGroupRepository) {
        this.repository = repository;
        this.userGroupRepository  = userGroupRepository;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return repository.save(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    @PostMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        User currentUser = repository.findOne(id);
        currentUser.setLogin(user.getLogin());
        currentUser.setPassword(user.getPassword());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setDateOfBirth(user.getDateOfBirth());
        return repository.save(currentUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
            repository.delete(id);

    }




}
