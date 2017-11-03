package com.ssh.service;


import com.ssh.model.User;
import java.util.List;

public interface IUserService {
    List<User> list();

    void save(User user);

    void remove(String id);

    User getUser(String id);

    void edit(User user);
}
