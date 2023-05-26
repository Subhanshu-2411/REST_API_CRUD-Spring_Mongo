package com.example.usermanagement.repository;

import com.example.usermanagement.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstNameStartsWith(String name);


//    List<Person> findByAgeBetween(Integer minAge, Integer maxAge);
    @Query(value = "{'age': { $gte: ?0, $lte: ?1}}", fields = "{addresses: 0}")
    List<Person> findUserByAgeBetween(Integer minAge, Integer maxAge);

}
