package com.nanemo.controller;

import com.nanemo.entity.Person;
import com.nanemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public String getPeople(Model model) {
        model.addAttribute("people", personService.getPeople());
        return "person/person_list";
    }

    //TODO This method isn't used
    @GetMapping("/{person_id}")
    public String getPersonById(Model model, @PathVariable("person_id") Integer personId) {
        model.addAttribute("person", personService.getPersonById(personId));
        return "person/show";
    }

    @GetMapping("/before_create")
    public String beforeCreate(Model model) {
        model.addAttribute("person", new Person());
        return "person/before_create";
    }

    //TODO I have to do persons_ordered_books.html page/ Page with names of book and with Person parameters
    @GetMapping("/ordered_book/{person_id}")
    public String listOfOrderedBooks(Model model, @PathVariable("person_id") Integer personId) {
        model.addAttribute("person", personService.getPersonWithOrderedBookList(personId));
        return "person/persons_ordered_books";
    }

    @PostMapping("/create")
    public String createPerson(@ModelAttribute("person") Person person) {
        personService.createPerson(person);
        return "redirect:/person/all";
    }

    @GetMapping("/before_update/{person_id}")
    public String beforeUpdate(Model model, @PathVariable("person_id") Integer personId) {
        model.addAttribute("person", personService.getPersonById(personId));
        return "person/before_update";
    }

    @PostMapping("/update/{person_id}")
    public String updatePerson(@ModelAttribute("person") Person person, @PathVariable("person_id") Integer personId) {
        personService.updatePerson(person, personId);
        return "redirect:/person/all";
    }

    @DeleteMapping("/delete/{person_id}")
    public String deletePerson(@PathVariable("person_id") Integer personId) {
        personService.deletePerson(personId);
        return "redirect:/person/all";
    }

}
