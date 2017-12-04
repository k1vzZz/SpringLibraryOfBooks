package ru.javastudy.springMVC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.javastudy.springMVC.model.Book;

import java.util.List;

@Repository
public class BookDao implements BookDaoInterface {

    public static final String SQL_SELECT_BOOK_BY_PARAM =
            "SELECT * FROM book " +
                    "WHERE name=? AND " +
                    "genre=? AND author=?;";
    public static final String SQL_DELETE_BOOK =
            "DELETE FROM book " +
                    "WHERE id = ?;";
    public static final String SQL_UPDATE_BOOK =
            "UPDATE book SET name = ?," +
                    "genre = ?, year = ?, author = ? " +
                    "WHERE id = ?;";
    public static final String SQL_SELECT_ALL_BOOK =
            "SELECT * FROM book;";
    public static final String SQL_SELECT_BOOK_BY_ID =
            "SELECT * FROM book " +
                    "WHERE id = ?;";
    public static final String SQL_INSERT_BOOK =
            "INSERT INTO book(name,genre,year,author,id_admin) " +
                    "VALUES (?,?,?,?,?);";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Book getBookById(int id) {
        Object[] objects = {id};
        return jdbcTemplate.queryForObject(SQL_SELECT_BOOK_BY_ID,
                objects, new BeanPropertyRowMapper<Book>(Book.class));
    }

    public Book getBookByParams(String name, String genre, String author) {
        Object[] objects = {name, genre, author};
        return jdbcTemplate.queryForObject(SQL_SELECT_BOOK_BY_PARAM,
                objects, new BeanPropertyRowMapper<Book>(Book.class));
    }

    public void setBook(Book book) {
        Object[] objects = {book.getName(), book.getGenre(),
                book.getYear(), book.getAuthor(), book.getIdAdmin()};
        jdbcTemplate.update(SQL_INSERT_BOOK, objects);
    }

    public void updateBookById(Book book) {
        Object[] objects = {book.getName(), book.getGenre(),
                book.getYear(), book.getAuthor(), book.getId()};
        jdbcTemplate.update(SQL_UPDATE_BOOK, objects);
    }

    public void deleteBookById(int id) {
        jdbcTemplate.update(SQL_DELETE_BOOK, id);
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query(SQL_SELECT_ALL_BOOK, new BeanPropertyRowMapper<Book>(Book.class));
    }
}
