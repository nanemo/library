package com.nanemo.controller;

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
        model.addAttribute("people", bookService);
        return null;
    }

    @GetMapping("/{book_id}")
    public String getBookById(@PathVariable("book_id") Integer bookId) {
        return null;
    }

    @PostMapping("/new")
    public String createBook(@PathVariable("book_id") Integer bookId) {
        return null;
    }

    @PostMapping("/{book_id}/update")
    public String updateBook(@PathVariable("book_id") Integer bookId) {
        return null;
    }

    @DeleteMapping("/delete/{book_id}")
    public String deleteBook(@PathVariable("book_id") Integer bookId) {
        return "redirect:book/all";
    }

}
