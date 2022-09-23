package com.mycompany.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.mycompany.exception.BusException;
import com.mycompany.pojo.Bus;

@Component
public class BusDao extends DAO {

    public BusDao() {
    }

    public Bus get(Bus bus) throws BusException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(Bus.class);
            crit.add(Restrictions.eq("busNumber", bus.getBusNumber()));

            Bus checkBus = (Bus) crit.uniqueResult();
            commit();
            return checkBus;

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Couldn't get Bus: " + bus.getBusNumber(), e);
        }
    }

    public Bus create(Bus bus) throws BusException {
        try {
            begin();
            getSession().save(bus);
            commit();
            return bus;
        } catch (HibernateException e) {
            rollback();
            throw new BusException("Exception while creating Bus:" + e.getMessage());
        }
    }

    public void delete(Bus bus) throws BusException {
        try {
            begin();
            getSession().delete("bus", bus);
            commit();

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Could not delete Bus " + bus.getBusNumber(), e);
        }
    }
    
    public void updateBus(Bus bus) throws BusException {
        try {
            begin();
            getSession().update(bus);
            commit();
            
        } catch (HibernateException e) {
            rollback();
            throw new BusException("Exception while update Bus:" + e.getMessage());
        }
    }
    
        public Bus getForUpdate(Bus bus) throws BusException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(Bus.class);
            crit.add(Restrictions.eq("busNumber", bus.getBusNumber()));
            crit.add(Restrictions.eq("sourceLocation", bus.getSourceLocation()));
            crit.add(Restrictions.eq("destinationLocation", bus.getDestinationLocation()));
            crit.add(Restrictions.eq("totalSeatsAvailable", bus.getTotalSeatsAvailable()));


            Bus checkBus = (Bus) crit.uniqueResult();
            commit();
            return checkBus;

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Couldn't get Bus: " + bus.getBusNumber(), e);
        }
    }
        
        public List<Bus> getAll() throws BusException {
            List<Bus> buses = new ArrayList<Bus>();
        try {
            begin();
            Criteria crit = getSession().createCriteria(Bus.class);
            buses = crit.list();
            commit();
            return buses;
            

        } catch (HibernateException e) {
            rollback();
            throw new BusException("Couldn't get Buses: " , e);
        }
    }
        
        
        
    
    

}
