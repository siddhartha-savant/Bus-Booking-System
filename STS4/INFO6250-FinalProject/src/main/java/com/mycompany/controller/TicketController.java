package com.mycompany.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.mycompany.dao.TicketDao;
import com.mycompany.exception.BusException;
import com.mycompany.pojo.Ticket;
import com.mycompany.pojo.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.sql.*;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Date;
import java.util.Iterator; 
import javax.persistence.Entity;

@Controller
@SessionAttributes("userLogin")
public class TicketController {
	Date date = new Date();

    private static SessionFactory factory;

    public TicketController() {
    }

    @GetMapping("bookTicket.htm")
    public String userAddTicket(ModelMap model, Ticket ticket) {

        model.addAttribute("ticket", ticket);
        return "UserTicketBooking";
    }

    @PostMapping("bookTicket.htm")
    public String userHandleAddTicket(ModelMap model, @ModelAttribute("ticket") Ticket ticket, BindingResult result, SessionStatus status, TicketDao ticketDao) throws BusException {

        if (result.hasErrors()) {
            return "UserTicketBooking";
        } else if(ticket.getDateOfTravel().before(date)){
            return "ticketError";
        }
        else {
            int num = (int) System.currentTimeMillis();
            ticket.setTicketRegistrationNumber(Math.abs(num));
            ticket.setDateOfBookingTicket(date);
            Ticket alreadyTicket = ticketDao.get(ticket);
            
            if (alreadyTicket == null) {
                ticketDao.create(ticket);
                status.setComplete();
                return "UserTicketAdded";
            } else {
                model.addAttribute("ticket", alreadyTicket);
                return "ticketError";
            }
        }
    }
    
    @GetMapping("deleteTicket.htm")
    public String userDeleteTicketFromAccount(ModelMap model, Ticket ticket) {

        model.addAttribute("ticket", ticket);
        return "UserDeleteTicket";
    }

    @PostMapping("deleteTicket.htm")
    public String userHandleDeleteTicketAccount(ModelMap model, @ModelAttribute("ticket") Ticket ticket, BindingResult result, SessionStatus status, TicketDao ticketDao) throws BusException {
        if (result.hasErrors()) {
            return "UserDeleteTicket";
        } else {
            Ticket alreadyTicket = ticketDao.get(ticket);
            if (alreadyTicket != null) {
                ticketDao.delete(alreadyTicket);
                status.setComplete();
                return "UserDeleteTicketSuccess";
            } else {
                model.addAttribute("ticket", alreadyTicket);
                return "UserDeleteTicketError";
            }
        }
    }
    
    @GetMapping("viewAllBookings.htm")
    public String userShowAccountInformation(HttpServletRequest request,TicketDao ticketDao, HttpSession session) throws BusException{
        List<Ticket> ticketList = ticketDao.getAll((User)(session.getAttribute("user")));
        request.setAttribute("ticketList", ticketList);
        return "viewBookingData";
    }

}
