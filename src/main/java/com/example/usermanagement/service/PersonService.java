package com.example.usermanagement.service;

import com.example.usermanagement.collection.Person;

import java.util.List;

public interface PersonService {
    public String save(Person person);

    List<Person> getPersonStartWith(String name);
}
