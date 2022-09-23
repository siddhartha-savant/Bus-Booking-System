package com.mycompany.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.dao.UserDao;
import com.mycompany.dao.BusDao;
import com.mycompany.dao.TicketDao;
import com.mycompany.exception.BusException;
import com.mycompany.pojo.User;
import com.mycompany.pojo.Bus;
import com.mycompany.pojo.Ticket;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userLogin")
public class UserController {
	Date date = new Date();

  
  @GetMapping("viewBusUser.htm")
  public String userShowBusInformation(HttpServletRequest request,BusDao busDao) throws BusException{
      List<Bus> busList = busDao.getAll();
      request.setAttribute("busList", busList);
      return "viewBusDataUser";
  }
  
    @GetMapping("userLogin.htm")
    public String userLoginFunction(ModelMap model, User user) {
        model.addAttribute("user", user);
        return "loginPage";
    }

    @PostMapping("userLogin.htm")
    public ModelAndView userHandleLoginFunction(@ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userdao, HttpSession session) throws BusException {

        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("register");
            return model;
        } else {
            User retrievedUser = userdao.get(user);
            System.out.println(retrievedUser.getUserName());
            if (retrievedUser != null) {
                session.setAttribute("user", retrievedUser);
                status.setComplete();
                ModelAndView model = new ModelAndView("userWelcome");
                return model;
            } else {
                ModelAndView model = new ModelAndView("error");
                return model;
            }
        }

    }
    
//  @GetMapping("viewAllBookings.htm")
//  public String userShowAccountInformation(HttpServletRequest request,TicketDao ticketDao, HttpSession session) throws BusException{
//      List<Ticket> ticketList = ticketDao.getAll((User)(session.getAttribute("user")));
//      request.setAttribute("ticketList", ticketList);
//      return "viewBookingData";
//  }
    
    @GetMapping("welcomeUser.htm")
    public ModelAndView userWelcomePage(HttpServletRequest request){
    	return new ModelAndView("userWelcome");
    }

    @GetMapping("userRegister.htm")
    public String userAccountRegistration(ModelMap model) {
        User user = new User();
            model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("userRegister.htm")
    public String userHandleAccountRegistration(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userdao) throws BusException{
        if (result.hasErrors()) {
            return "register";
        } else {
            User alreadyUser = userdao.get(user);
            if (alreadyUser == null) {
                if (user.getAge() <= 0 || (user.getContactNumber().length()!=10)){
                	return "registerError";
                }
                userdao.create(user);
                
//                Email email = new SimpleEmail();
//                email.setHostName("smtp.googlemail.com");
//                email.setSmtpPort(465);
//                email.setAuthenticator(new DefaultAuthenticator("hh.helpinghands123@gmail.com", "helpinghands"));
//                email.setSSLOnConnect(true);
//                email.setFrom("hh.helpinghands123@gmail.com");
//                email.setSubject("Registration");
//                email.setMsg("You have successfully been registered");
//                email.addTo(user.getEmailAddress()); 
//                email.send();
//                
                status.setComplete();
                       
                return "UserAddedToApp";
            } else {
                model.addAttribute("user", alreadyUser);
                return "userAlreadyPresent";
            }
        }
    }


    @RequestMapping("logout.htm")
    public ModelAndView userLogout(HttpSession session) {
        session.invalidate();
        ModelAndView model = new ModelAndView("redirect:/");
        return model;
    }

//    @GetMapping("bookTicket.htm")
//    public String userAddTicket(ModelMap model, Ticket ticket) {
//
//        model.addAttribute("ticket", ticket);
//        return "UserTicketBooking";
//    }
//
//    @PostMapping("bookTicket.htm")
//    public String userHandleAddTicket(ModelMap model, @ModelAttribute("ticket") Ticket ticket, BindingResult result, SessionStatus status, TicketDao ticketDao) throws BusException {
//
//        if (result.hasErrors()) {
//            return "UserTicketBooking";
//        } else if(ticket.getDateOfTravel().before(date)){
//            return "ticketError";
//        }
//        else {
//            int num = (int) System.currentTimeMillis();
//            ticket.setTicketRegistrationNumber(Math.abs(num));
//            ticket.setDateOfBookingTicket(date);
//            Ticket alreadyTicket = ticketDao.get(ticket);
//            
//            if (alreadyTicket == null) {
//                ticketDao.create(ticket);
//                status.setComplete();
//                return "UserTicketAdded";
//            } else {
//                model.addAttribute("ticket", alreadyTicket);
//                return "ticketError";
//            }
//        }
//    }

    @GetMapping("closeAccount.htm")
    public String userAccountClosure(ModelMap model, User user) {

        model.addAttribute("user", user);
        return "UserClosurePage";
    }

    @PostMapping("closeAccount.htm")
    public String userHandleAccountClosure(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userDao) throws BusException {
        if (result.hasErrors()) {
            return "UserClosurePage";
        } else {
            User alreadyUser = userDao.getforDelete(user);
            if (alreadyUser != null) {
                userDao.delete(alreadyUser);
                status.setComplete();
                return "UserAccountDeletedSuccessfully";
            } else {
                model.addAttribute("user", alreadyUser);
                return "UserAccountClosureError";
            }

        }

    }
    
    
//    @GetMapping("deleteTicket.htm")
//    public String userDeleteTicketFromAccount(ModelMap model, Ticket ticket) {
//
//        model.addAttribute("ticket", ticket);
//        return "UserDeleteTicket";
//    }
//
//    @PostMapping("deleteTicket.htm")
//    public String userHandleDeleteTicketAccount(ModelMap model, @ModelAttribute("ticket") Ticket ticket, BindingResult result, SessionStatus status, TicketDao ticketDao) throws BusException {
//        if (result.hasErrors()) {
//            return "UserDeleteTicket";
//        } else {
//            Ticket alreadyTicket = ticketDao.get(ticket);
//            if (alreadyTicket != null) {
//                ticketDao.delete(alreadyTicket);
//                status.setComplete();
//                return "UserDeleteTicketSuccess";
//            } else {
//                model.addAttribute("ticket", alreadyTicket);
//                return "UserDeleteTicketError";
//            }
//        }
//    }
//    
    
    @GetMapping("updateUserInfo.htm")
    public String userUpdateUserInformation(ModelMap model, User user) {

        model.addAttribute("user", user);
        return "UserEditAccountInformation";
    }
    
    
    @PostMapping("updateUserInfo.htm")
    public String userHandleUpdateUserInformation(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userDao) throws BusException {
        if (result.hasErrors()) {
            return "UserEditAccountInformation";
        } else {
            
            User alreadyUser = userDao.getforDelete(user);
            if (alreadyUser != null) {
                userDao.delete(alreadyUser);
                userDao.create(user);
                status.setComplete();
                return "updateUserSuccess";
            } else {
                model.addAttribute("user", alreadyUser);
                return "userError";
            }
        }

    }
    
}
