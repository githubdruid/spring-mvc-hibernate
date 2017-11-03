package com.ssh.service.impl;

import com.ssh.dao.IUserDao;
import com.ssh.model.User;
import com.ssh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao userDao;
    @Transactional(readOnly = true)
    public List<User> list() {
        return userDao.list();
    }

    @Override
    @Transactional
    public void save(User user) {
            userDao.save(user);
    }

    @Override
    @Transactional
    public void remove(String id) {
        userDao.remove(Long.parseLong(id));
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(String id) {
        return userDao.getUser(Long.parseLong(id));
    }

    @Override
    @Transactional
    public void edit(User user) {
        userDao.edit(user);
    }
}
