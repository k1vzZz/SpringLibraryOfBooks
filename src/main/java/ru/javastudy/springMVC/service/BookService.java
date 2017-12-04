package ru.javastudy.springMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javastudy.springMVC.dao.BookDaoInterface;
import ru.javastudy.springMVC.model.Book;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDaoInterface bookDao;

    public List<Book> getBooks() {
        return bookDao.getAllBooks();
    }

    public Book getBook(int id) {
        return bookDao.getBookById(id);
    }

    public int getIdBook(Book book) {
        return bookDao.getBookByParams(book.getName(), book.getGenre(), book.getAuthor()).getId();
    }

    public void insertBook(Book book) {
        bookDao.setBook(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBookById(book);
    }

    public void deleteBook(int id) {
        bookDao.deleteBookById(id);
    }
}
