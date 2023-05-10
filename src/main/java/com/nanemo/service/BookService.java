package com.nanemo.service;

import com.nanemo.entity.Book;
import com.nanemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.getAll();
    }

    public Optional<Book> getBookById(Integer id){
        return bookRepository.getById(id);
    }

    public void createBook(Book book){
        bookRepository.create(book);
    }

    public void updateBook(Book book, Integer id){
        bookRepository.update(book, id);
    }

    public void deleteBook(Integer id){
        bookRepository.delete(id);
    }

}
