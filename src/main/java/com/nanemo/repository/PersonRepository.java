package com.nanemo.repository;

import com.nanemo.entity.Book;
import com.nanemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository implements AbstractRepository<Person> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getAll() {
        return jdbcTemplate.query("SELECT * FROM person ORDER BY person.person_id", new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public Person getById(Integer id) {
        return jdbcTemplate.query("SELECT p.* FROM person p WHERE p.person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    @Override
    public void create(Person person) {
        jdbcTemplate.update("INSERT INTO person (name, birthday) VALUES (?, ?)", person.getName(), person.getBirthday());
    }

    @Override
    public void update(Person person, Integer id) {
        jdbcTemplate.update("UPDATE person p SET p.name=?, p.birthday=? WHERE p.person_id=?",
                person.getName(), person.getBirthday(), person.getPersonId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM person p WHERE p.person_id=?", id);
    }

    public List<Book> getPersonOrderedBookList(Integer personId) {
        return jdbcTemplate.query("SELECT b.book_name, b.author_name, b.release_date FROM book b WHERE b.person_id=?",
                new Object[]{personId}, new BeanPropertyRowMapper<>(Book.class));
    }


    public List<Book> getFreeBookLists(Integer personId) {
        return jdbcTemplate.query("SELECT * FROM book b WHERE b.person_id IS NULL",
                new BeanPropertyRowMapper<>(Book.class));
    }
}
