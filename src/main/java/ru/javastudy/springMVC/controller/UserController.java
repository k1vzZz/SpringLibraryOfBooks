package ru.javastudy.springMVC.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.User;
import ru.javastudy.springMVC.service.UserService;
import ru.javastudy.springMVC.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {

    private final UserService userService;
    @Autowired
    private UserValidator userValidator;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView createUserProfile(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView addUserFromForm(@ModelAttribute User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            return modelAndView;
        } else {
            if (!userService.existenceUser(user)) {
                userService.insertUser(user);
                String successful = "Registration successful.";
                modelAndView.addObject("message", successful);
            } else {
                String error = "User with such login exists.";
                modelAndView.addObject("message", error);
            }
            user.setLogin(null);
            user.setPassword(null);
            user.setConfirmPassword(null);
            modelAndView.setViewName("registration");
            return modelAndView;
        }
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView hello(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public ModelAndView entry(@ModelAttribute User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        user.setConfirmPassword(user.getPassword());
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("home");
            return modelAndView;
        } else {
            if (userService.validationUser(user)) {
                user.setId(userService.getIdUser(user));
                modelAndView.setViewName("redirect:/library");
            } else {
                user.setPassword(null);
                modelAndView.addObject("message", "Input Error.");
                modelAndView.addObject("inputError", "Error.");
                modelAndView.setViewName("successfully");
            }
            return modelAndView;
        }
    }
}
