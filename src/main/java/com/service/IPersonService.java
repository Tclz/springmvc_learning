package com.service;

import com.domain.Person;

import java.util.List;

public interface IPersonService {
    public List<Person> findAll();
    public void savePerson(Person person);
}
