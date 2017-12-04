package ru.javastudy.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.Book;
import ru.javastudy.springMVC.model.User;
import ru.javastudy.springMVC.service.BookService;
import ru.javastudy.springMVC.validator.BookValidator;


@Controller
@SessionAttributes("user")
public class HomeController {

    private final BookService bookService;
    @Autowired
    private BookValidator bookValidator;

    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/exit")
    public ModelAndView exit(ModelAndView modelAndView, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public ModelAndView showPageLibrary(ModelAndView modelAndView) {
        modelAndView.addObject("books", bookService.getBooks());
        modelAndView.setViewName("library");
        return modelAndView;
    }

    @RequestMapping(value = "/library/{id}/update", method = RequestMethod.GET)
    public ModelAndView showPageUpdate(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", bookService.getBook(id));
        modelAndView.setViewName("update-book");
        return modelAndView;
    }

    @RequestMapping(value = "/library/{id}/update", method = RequestMethod.POST)
    public ModelAndView showBookFromForm(@PathVariable int id,
                                         @ModelAttribute Book book,
                                         BindingResult bindingResult) {
        book.setId(id);
        ModelAndView modelAndView = new ModelAndView();
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("update-book");
            return modelAndView;
        } else {
            bookService.updateBook(book);
            modelAndView.addObject("suffix", id);
            modelAndView.addObject("message", "Update successfully.");
            modelAndView.setViewName("successfully");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/library/{id}", method = RequestMethod.GET)
    public ModelAndView showPageBook(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", bookService.getBook(id));
        modelAndView.setViewName("page-book");
        return modelAndView;
    }

    @RequestMapping(value = "/library/add", method = RequestMethod.GET)
    public ModelAndView showPageAddBook(@ModelAttribute User user, ModelAndView modelAndView) {
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("add-book");
        return modelAndView;
    }

    @RequestMapping(value = "/library/add", method = RequestMethod.POST)
    public ModelAndView showFormAddBook(@ModelAttribute User user,
                                        @ModelAttribute Book book,
                                        BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("add-book");
            return modelAndView;
        } else {
            book.setIdAdmin(user.getId());
            bookService.insertBook(book);
            modelAndView.addObject("suffix", bookService.getIdBook(book));
            modelAndView.addObject("message", "Adding successfully.");
            modelAndView.setViewName("successfully");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/library/delete")
    public ModelAndView deleteBook(@RequestParam int id, ModelAndView modelAndView) {
        bookService.deleteBook(id);
        modelAndView.addObject("message", "Uninstall completed successfully.");
        modelAndView.setViewName("successfully");
        return modelAndView;
    }
}