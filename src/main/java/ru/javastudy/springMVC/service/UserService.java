package ru.javastudy.springMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javastudy.springMVC.dao.UserDaoInterface;
import ru.javastudy.springMVC.model.User;

@Service
public class UserService {
    @Autowired
    private UserDaoInterface userDao;

    public boolean existenceUser(User user) {
        return userDao.getUserByLogin(user.getLogin()) != null;
    }

    public void insertUser(User user) {
        userDao.setUser(user);
    }

    public boolean validationUser(User user) {
        return userDao.getUserByLoginAndPassword(user.getLogin(), user.getPassword()) != null;
    }

    public int getIdUser(User user) {
        return userDao.getUserByLoginAndPassword(user.getLogin(), user.getPassword()).getId();
    }
}
