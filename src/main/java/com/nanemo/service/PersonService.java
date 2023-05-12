package com.nanemo.service;

import com.nanemo.entity.Person;
import com.nanemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople() {
        return personRepository.getAll();
    }

    public Person getPersonById(Integer personId) {
        return personRepository.getById(personId);
    }

    public void createPerson(Person person) {
        personRepository.create(person);
    }

    public void updatePerson(Person person, Integer personId) {
        personRepository.update(person, personId);
    }

    public void deletePerson(Integer personId) {
        personRepository.delete(personId);
    }

    public Person getPersonWithOrderedBookList(Integer personId) {
        Person person = personRepository.getById(personId);
        person.setBookList(personRepository.getPersonOrderedBookList(personId));

        return person;
    }
}
