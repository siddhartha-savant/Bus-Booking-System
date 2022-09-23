package com.mycompany.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.mycompany.exception.BusException;
import com.mycompany.pojo.User;

@Component
public class UserDao extends DAO {

    public UserDao() {
    }

    public User get(User user) throws BusException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(User.class);
            crit.add(Restrictions.eq("emailAddress", user.getEmailAddress()));
            crit.add(Restrictions.eq("password", user.getPassword()));
            User loggedInUser = (User) crit.uniqueResult();
            commit();
            return loggedInUser;

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Couldn't get user " + user.getEmailAddress(), e);
        }
    }

    public User getforDelete(User user) throws BusException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(User.class);
            crit.add(Restrictions.eq("emailAddress", user.getEmailAddress()));

            User loggedInUser = (User) crit.uniqueResult();
            commit();
            return loggedInUser;

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Couldn't get user " + user.getEmailAddress(), e);
        }
    }

    public User create(User user) throws BusException {
        try {
            begin();
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new BusException("Exception while creating user:" + e.getMessage());
        }
    }

    public void delete(User user) throws BusException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new BusException("Could not delete user " + user.getEmailAddress(), e);
        }
    }

    public List<User> getAll() throws BusException {
        List<User> users = new ArrayList<User>();
        try {
            begin();
            Criteria crit = getSession().createCriteria(User.class);
            users = crit.list();
            commit();
            return users;

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Couldn't get Users: ", e);
        }

    }
}
