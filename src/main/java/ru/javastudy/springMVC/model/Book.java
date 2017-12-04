package ru.javastudy.springMVC.model;


import org.springframework.stereotype.Component;

@Component
public class Book {

    private int id;
    private String name;
    private String genre;
    private String year;
    private String author;
    private int id_admin;

    public Book() {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getIdAdmin() {
        return id_admin;
    }

    public void setIdAdmin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
