package com.example.vacayday.backend.service;


import com.example.vacayday.backend.entity.Vacation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RestController
public class VacationService implements CrudListener<Vacation> {

    private final VacationRepository repository;

    public VacationService(VacationRepository repository){
        this.repository = repository;
    }

    @Override
    public Collection<Vacation> findAll() {
        return repository.findAll();
    }

    @Override
    public Vacation add(Vacation vacation) {
        return repository.save(vacation);
    }

    @Override
    public Vacation update(Vacation vacation) {
        return repository.save(vacation);
    }

    @Override
    public void delete(Vacation vacation) {
        repository.delete(vacation);
    }
}
