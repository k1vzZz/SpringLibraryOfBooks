package ru.javastudy.springMVC.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.javastudy.springMVC.model.Book;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BookValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        Book book;
        if (target instanceof Book) {
            book = (Book) target;
        } else return;

        Matcher matcher;
        Pattern pattern;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "name.empty", "Name book must not be empty.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre",
                "genre.empty", "Genre must not be empty.");
        pattern = Pattern.compile("^[a-zA-Z]+$");
        matcher = pattern.matcher(book.getGenre());
        if (!matcher.matches())
            errors.rejectValue("genre", "genre.notMatching", "Not a valid genre.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year",
                "year.empty", "Year must not be empty.");
        pattern = Pattern.compile("[0-9]{4}");
        matcher = pattern.matcher(book.getYear());
        if (!matcher.matches())
            errors.rejectValue("year", "year.notMatching", "Year format:YYYY");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author",
                "author.empty", "Author must not be empty.");
        pattern = Pattern.compile("^[a-zA-Z\\.\\t\\n\\r\\f\\v ]{1,100}$");
        matcher = pattern.matcher(book.getAuthor());
        if (!matcher.matches())
            errors.rejectValue("author", "author.notMatching", "Not a valid author name.");


    }
}
