package com.ssh.dao.Impl;

import com.ssh.dao.IUserDao;
import com.ssh.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void remove(long id) {
        User user=getUser(id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getUser(long id) {
        User user= sessionFactory.getCurrentSession().get(User.class,id);
        return user;
    }

    @Override
    public void edit(User user) {
        sessionFactory.getCurrentSession().update(user);
    }
}
