package com.mycompany.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.mycompany.exception.BusException;
import com.mycompany.pojo.Bus;
import com.mycompany.pojo.Ticket;
import com.mycompany.pojo.User;

@Component
public class TicketDao extends DAO{
    
    public TicketDao(){}
    
    public Ticket get(Ticket ticket) throws BusException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(Ticket.class);
            crit.add(Restrictions.eq("ticketRegistrationNumber", ticket.getTicketRegistrationNumber()));
            
            Ticket checkTicket = (Ticket) crit.uniqueResult();
            commit();
            return checkTicket;

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Couldn't get Bus: " + ticket.getTicketRegistrationNumber(), e);
        }
    }
    
        

    public Ticket create(Ticket ticket) throws BusException {
        try {
            begin();
            getSession().save(ticket);
            commit();
            return ticket;
        } catch (HibernateException e) {
            rollback();
            throw new BusException("Exception while creating Ticket:" + e.getMessage());
        }
    }

    public void delete(Ticket ticket)  throws BusException {
        try {
            begin();
            getSession().delete(ticket);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new BusException("Could not delete user " + ticket.getTicketRegistrationNumber(), e);
        }
    }
    
        public List<Ticket> getAll(User user) throws BusException {
        List<Ticket> tickets = new ArrayList<Ticket>();
        try {
            begin();
            Criteria crit = getSession().createCriteria(Ticket.class);
            crit.add(Restrictions.eq("emailAddress", user.getEmailAddress()));

            tickets = crit.list();
            commit();
            return tickets;

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Couldn't get Bookings: ", e);
        }

    }
        
        public Bus getBus(Ticket ticket) throws BusException {
            try {
                begin();
                Criteria crit = getSession().createCriteria(Ticket.class);
                crit.add(Restrictions.eq("busNumber", ticket.getBusNumber()));
                
                Bus checkBus = (Bus) crit.uniqueResult();
                commit();
                return checkBus;

            } catch (HibernateException e) {
                rollback();
                throw new BusException("Couldn't get Bus: " + ticket.getTicketRegistrationNumber(), e);
            }
        }
    
}

