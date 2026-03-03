package com.example.vacayday.backend.service;

import com.example.vacayday.backend.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RestController
public class UserService implements CrudListener<User> {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public Collection<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }
}
