package com.ssh.dao;

import com.ssh.model.User;

import java.util.List;

public interface IUserDao {
    List<User> list();

    void save(User user);

    void remove(long l);

    User getUser(long l);

    void edit(User user);
}
