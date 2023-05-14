package com.nanemo.repository;

import com.nanemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository implements AbstractRepository<Book> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query("SELECT * FROM Book ORDER BY book.book_id", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO Book (book_name, author_name, release_date) VALUES (?,?,?)", book.getBookName(), book.getAuthorName(), book.getReleaseDate());
    }

    @Override
    public void update(Book book, Integer id) {
        jdbcTemplate.update("UPDATE Book SET book_name=?, author_name=?, release_date=? WHERE book_id=?",
                book.getBookName(),
                book.getAuthorName(),
                book.getReleaseDate(),
                id);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }

    public void addBookToPersonBalance(Integer personId, Integer bookId) {
        jdbcTemplate.update("UPDATE book b SET b.person_id=? WHERE b.book_id=?", personId, bookId);
    }
}
