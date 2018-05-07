package com.sda.budzet.db.repository.impl;

import com.sda.budzet.db.model.User;
import com.sda.budzet.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepositoryJdbc")
public class UserRepositoryJdbc implements UserRepository {

    private static final String INSERT_SQL = "INSERT INTO users(login, password, email) VALUES ('%s', '%s', '%s')";
    private static final String SELECT_BY_LOGIN_AND_PASSWORD_SQL = "SELECT * FROM users WHERE login = '%s' AND password = '%s'";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean isLoginExists(String login) {
        List<String> result = jdbcTemplate.queryForList("SELECT login FROM users WHERE login=?", new Object[]{login}, String.class);
        return !result.isEmpty();
    }

    @Override
    public void save(User user) {
        jdbcTemplate.execute(String.format(INSERT_SQL, user.getLogin(), user.getPassword(), user.getEmail()));
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        BeanPropertyRowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(String.format(SELECT_BY_LOGIN_AND_PASSWORD_SQL, login, password), mapper);
        if (users.size() == 1){
            return users.get(0);
        }
        return null;
    }
}
