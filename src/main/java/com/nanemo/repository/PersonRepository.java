package com.nanemo.repository;

import com.nanemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository implements AbstractRepository<Person>{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public Person getById(Integer id) {
        return null;
    }

    @Override
    public void create(Person person) {

    }

    @Override
    public void update(Person person, Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }
}
