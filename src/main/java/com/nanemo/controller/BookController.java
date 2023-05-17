package com.nanemo.controller;

import com.nanemo.entity.Book;
import com.nanemo.service.BookService;
import com.nanemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final PersonService personService;

    @Autowired
    public BookController(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }

    @GetMapping("/all")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book/book_list";
    }

    @PostMapping("/add_book_to_person/{person_id}/{book_id}")
    public String addBookToPersonBalance(@PathVariable("person_id") Integer personId,
                                         @PathVariable("book_id") Integer bookId) {
        bookService.addBookToPersonBalance(personId, bookId);
        return "redirect:/person/free_book/" + personId;
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/new";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute("book") Book book) {
        bookService.createBook(book);
        return "redirect:/book/all";
    }

    @PostMapping("/delete_book_from_person_list/{person_id}/{book_id}")
    public String deleteBookFromPersonList(ModelMap modelMap,
                                           @PathVariable("person_id") Integer personId,
                                           @PathVariable("book_id") Integer bookId) {
        bookService.deleteBookFromPersonList(bookId);
        modelMap.addAttribute("person", personService.getPersonWithOrderedBookList(personId));
        return "person/persons_ordered_books";
    }

    @GetMapping("/before_update/{book_id}")
    public String beforeUpdateBook(Model model, @PathVariable("book_id") Integer bookId) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "book/update";
    }

    @PostMapping("/update/{book_id}")
    public String updateBook(@ModelAttribute("book") Book book, @PathVariable("book_id") Integer bookId) {
        bookService.updateBook(book, bookId);
        return "redirect:/book/all";
    }

    @DeleteMapping("/delete/{book_id}")
    public String deleteBook(@PathVariable("book_id") Integer bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/book/all";
    }

}
