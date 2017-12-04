package ru.javastudy.springMVC.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.javastudy.springMVC.model.User;

import java.util.List;

@Repository
public class UserDao implements UserDaoInterface {

    public static final String SQL_SELECT_USER_BY_LOGIN_AND_PAS =
            "SELECT * FROM user " +
                    "WHERE login = ? " +
                    "AND password = ?;";

    public static final String SQL_SELECT_USER_BY_LOGIN =
            "SELECT * FROM user " +
                    "WHERE login = ?;";

    public static final String SQL_INSERT_USER =
            "INSERT INTO user(login, password) " +
                    "VALUES(?,?);";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByLogin(String login) {
        Object[] objects = {login};
        List<User> list = jdbcTemplate.query(SQL_SELECT_USER_BY_LOGIN,
                objects, new BeanPropertyRowMapper<User>(User.class));
        if (list.size() == 0) return null;
        else return list.get(0);
    }

    public User getUserByLoginAndPassword(String login, String password) {
        Object[] objects = {login, password};
        List<User> list = jdbcTemplate.query(SQL_SELECT_USER_BY_LOGIN_AND_PAS,
                objects, new BeanPropertyRowMapper<User>(User.class));
        if (list.size() == 0) return null;
        else return list.get(0);
    }

    public void setUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
                user.getLogin(),
                user.getPassword());
    }
}
