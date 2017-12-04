package ru.javastudy.springMVC.dao;

import ru.javastudy.springMVC.model.Book;

import java.util.List;

public interface BookDaoInterface {
    Book getBookById(int id);

    Book getBookByParams(String nameBook, String genre, String author);

    void setBook(Book book);

    List<Book> getAllBooks();

    void updateBookById(Book book);

    void deleteBookById(int id);
}
