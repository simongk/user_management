package com.simongk.controllers;

import com.simongk.entities.User;
import com.simongk.entities.UserGroup;
import com.simongk.repositories.UserGroupRepository;
import com.simongk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 2017-02-14.
 */
@RestController
@RequestMapping("/groups")
public class UserGroupController {


    private UserGroupRepository repository;
    private UserRepository userRepository;

    @Autowired
    public UserGroupController(UserGroupRepository repository,UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public UserGroup addUserGroup(@RequestBody UserGroup userGroup){
        return repository.save(userGroup);
    }

    @GetMapping("/all")
    public List<UserGroup> getAllGroups(){
        return repository.findAll();
    }

    @PostMapping("/update/{id}")
    public UserGroup updateGroup(@RequestBody UserGroup userGroup, @PathVariable Long id){
        UserGroup currentGroup = repository.findOne(id);
        currentGroup.setName(userGroup.getName());
        currentGroup.setUsers(userGroup.getUsers());
        return repository.save(currentGroup);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroup(@PathVariable Long id){
        repository.delete(id);
    }




}
