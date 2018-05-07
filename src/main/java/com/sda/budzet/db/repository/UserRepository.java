package com.sda.budzet.db.repository;

import com.sda.budzet.db.model.User;

public interface UserRepository {
    boolean isLoginExists(String login);

    void save(User user);

    User findByLoginAndPassword(String login, String password);
}
