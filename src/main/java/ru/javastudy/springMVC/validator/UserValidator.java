package ru.javastudy.springMVC.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.javastudy.springMVC.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        User user;
        if (target instanceof User)
            user = (User) target;
        else return;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login",
                "login.empty", "Login must not be empty.");
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,25}$");
        Matcher matcher = pattern.matcher(user.getLogin());
        if (!matcher.matches())
            errors.rejectValue("login", "login.notMatches", "Not a valid login.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "password.empty", "Password must not be empty");
        if (user.getPassword().length() < 4) {
            errors.rejectValue("password",
                    "password.length", "Password length shout be more 3 symbols.");
        }
        pattern = Pattern.compile("^[a-zA-Z0-9]{1,40}$");
        matcher = pattern.matcher(user.getPassword());
        if (!matcher.matches())
            errors.rejectValue("password", "password.notMatches", "Not a valid password.");

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword",
                    "confirmPassword.passwordDontMatch",
                    "Passwords don't match.");
        }

    }
}