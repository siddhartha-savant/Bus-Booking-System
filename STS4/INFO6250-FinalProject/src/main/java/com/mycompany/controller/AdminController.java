package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.dao.AdminDao;
import com.mycompany.exception.BusException;
import com.mycompany.pojo.Admin;
import com.mycompany.dao.BusDao;
import com.mycompany.pojo.Bus;
import com.mycompany.pojo.User;
import com.mycompany.dao.UserDao;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("adminLogin")
public class AdminController {

    @GetMapping("adminLogin.htm")
    public String adminstrativeLoginForm(ModelMap model, Admin admin) {
        model.addAttribute("admin", admin);
        return "AdminLoginCredentials";
    }

    @PostMapping("adminLogin.htm")
    public ModelAndView adminstrativeHandleLoginForm(@ModelAttribute("admin") Admin admin, BindingResult result, SessionStatus status, AdminDao adminDao, HttpSession session) throws BusException {

        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("index");
            return model;
        } else {
            Admin retrievedAdmin = adminDao.get(admin);
            System.out.println(retrievedAdmin);
            if (retrievedAdmin != null) {
                session.setAttribute("admin", retrievedAdmin);
                status.setComplete();
                ModelAndView model = new ModelAndView("AdminWelcomePage");
                return model;
            } else {
                ModelAndView model = new ModelAndView("error");
                return model;
            }
        }

    }
    
    @GetMapping("welcomeAdmin.htm")
    public ModelAndView adminWelcomePage(HttpServletRequest request){
    	return new ModelAndView("AdminWelcomePage");
    }

    @GetMapping("createBus.htm")
    public String adminstrativeCreateBusForm(ModelMap model, Bus bus) {

        model.addAttribute("bus", bus);
        return "AdminAddBusData";
    }
    

    @PostMapping("createBus.htm")
    public String adminstrativeHandleCreateBusForm(ModelMap model, @ModelAttribute("bus") Bus bus, BindingResult result, SessionStatus status, BusDao busDao) throws BusException {

        if (result.hasErrors()) {
            return "AdminAddBusData";
        } else {
            Bus alreadyBus = busDao.get(bus);
            if (alreadyBus == null) {
                busDao.create(bus);
                status.setComplete();
                return "AdminBusDataAdded";
            } else {
                model.addAttribute("bus", alreadyBus);
                return "AdminBusError";
            }
        }
    }

    @GetMapping("editBus.htm")
    public String administrativeEditBusForm(ModelMap model, Bus bus) {

        model.addAttribute("bus", bus);
        return "AdminEditBusData";
    }

    @PostMapping("editBus.htm")
    public String administrativeHandleEditBusForm(ModelMap model, @ModelAttribute("bus") Bus bus, BindingResult result, SessionStatus status, BusDao busDao) throws BusException {
        if (result.hasErrors()) {
            return "AdminEditBusData";
        } else {
            Bus alreadyBus = busDao.get(bus);
            bus.setBusID(alreadyBus.getBusID());
            if (alreadyBus != null) {
                busDao.delete(alreadyBus);
                busDao.create(bus);
                status.setComplete();
                return "updateBusSuccess";
            } else {
                model.addAttribute("bus", alreadyBus);
                return "AdminBusError";
            }
        }

    }

    @GetMapping("deleteBus.htm")
    public String administrativeDeleteBusForm(ModelMap model, Bus bus) {

        model.addAttribute("bus", bus);
        return "AdminDeleteBusData";
    }

    @PostMapping("deleteBus.htm")
    public String administrativeHandleDeleteBusForm(ModelMap model, @ModelAttribute("bus") Bus bus, BindingResult result, SessionStatus status, BusDao busDao) throws BusException {
        if (result.hasErrors()) {
            return "AdminAddBusData";
        } else {
            Bus alreadyBus = busDao.get(bus);
            if (alreadyBus != null) {
                busDao.delete(alreadyBus);
                status.setComplete();
                return "AdminDeleteBusSuccesfully";
            } else {
                model.addAttribute("bus", alreadyBus);
                return "AdminBusError";
            }
        }
    }

    @GetMapping("updateUser.htm")
    public String administrativeUpdateUserForm(ModelMap model, User user) {
        model.addAttribute("user", user);
        return "AdminEditUserData";
    }
    
    
    @PostMapping("updateUser.htm")
    public String administrativeHandleUpdateUserForm(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userDao) throws BusException {
        if (result.hasErrors()) {
            return "AdminEditUserData";
        } else {
            User alreadyUser = userDao.getforDelete(user);
            if (alreadyUser != null) {
                userDao.delete(alreadyUser);
                userDao.create(user);
                status.setComplete();
                return "updateAdminSuccess";
            } else {
                model.addAttribute("user", alreadyUser);
                return "userError";
            }
        }

    }

    @GetMapping("deleteUser.htm")
    public String administrativeDeleteUserForm(ModelMap model, User user) {

        model.addAttribute("user", user);
        return "AdminDeleteUser";
    }

    @PostMapping("deleteUser.htm")
    public String administrativeHandleDeleteUserForm(ModelMap model, @ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userDao) throws BusException {
        if (result.hasErrors()) {
            return "AdminDeleteUser";
        } else {
            User alreadyUser = userDao.getforDelete(user);
            if (alreadyUser != null) {
                userDao.delete(alreadyUser);
                status.setComplete();
                return "AdminUserDeletedSuccesfully";
            } else {
                model.addAttribute("bus", alreadyUser);
                return "userError";
            }
        }
    }
    
    
    @GetMapping("viewBus.htm")
    public String administrativeViewBusInfo(HttpServletRequest request,BusDao busDao) throws BusException{
        List<Bus> busList = busDao.getAll();
        request.setAttribute("busList", busList);
        return "viewBusData";
    }
      
    @GetMapping("viewAllUsers.htm")
    public String administrativeViewAllUsers(HttpServletRequest request,UserDao userDao) throws BusException{
        List<User> userList = userDao.getAll();
        request.setAttribute("userList", userList);
        return "viewUserData";
    }
     

}
