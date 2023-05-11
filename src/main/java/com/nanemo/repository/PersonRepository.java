package com.nanemo.repository;

import com.nanemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository implements AbstractRepository<Person> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getAll() {
        return jdbcTemplate.query("SELECT * FROM person Left Join book b on person.person_id = b.person_id ORDER BY person.person_id", new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public Person getById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM person p WHERE p.person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    @Override
    public void create(Person person) {
        jdbcTemplate.update("INSERT INTO person (name, birthday) VALUES (?, ?)", person.getName(), person.getBirthdate());
    }

    @Override
    public void update(Person person, Integer id) {
        jdbcTemplate.update("UPDATE person p SET p.name=?, p.birthday=? WHERE p.person_id=?",
                person.getName(), person.getBirthdate(), person.getPersonId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM person p WHERE p.person_id=?", id);
    }
}
