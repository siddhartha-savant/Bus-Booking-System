package com.mycompany.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.mycompany.exception.BusException;
import com.mycompany.pojo.Admin;

@Component
public class AdminDao extends DAO {

    public AdminDao() {
    }

    public Admin get(Admin admin) throws BusException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(Admin.class);
            crit.add(Restrictions.eq("emailID", admin.getEmailID()));
            crit.add(Restrictions.eq("password", admin.getPassword()));
            Admin loggedInAdmin = (Admin) crit.uniqueResult();
            commit();
            return loggedInAdmin;

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Couldn't get Admin " + admin.getEmailID(), e);
        }
    }

}
