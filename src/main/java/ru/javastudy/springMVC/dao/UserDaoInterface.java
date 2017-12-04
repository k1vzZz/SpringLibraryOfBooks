package ru.javastudy.springMVC.dao;

import ru.javastudy.springMVC.model.User;

public interface UserDaoInterface {
    void setUser(User user);

    User getUserByLogin(String login);

    User getUserByLoginAndPassword(String login, String password);
}
