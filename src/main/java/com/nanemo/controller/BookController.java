package com.nanemo.controller;

import com.nanemo.entity.Book;
import com.nanemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book/book_list";
    }

    @GetMapping("/{book_id}")
    public String getBookById(@PathVariable("book_id") Integer bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "book/show";
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

    @GetMapping("/before_update/{book_id}")
    public String beforeUpdateBook(Model model, @PathVariable("book_id") Integer bookId){
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
