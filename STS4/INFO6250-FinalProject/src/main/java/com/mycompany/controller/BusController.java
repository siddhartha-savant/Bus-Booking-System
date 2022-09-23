package com.mycompany.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.dao.BusDao;
import com.mycompany.exception.BusException;
import com.mycompany.pojo.Bus;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("adminLogin")
public class BusController {
    
    
    // Login Page
//    @GetMapping("busData.htm")
//    public String showBusForm(ModelMap model, Bus bus) {
//        
//        model.addAttribute("bus", bus);
//        return "AdminAddBusData";
//    }
	
//	  @GetMapping("viewBusUser.htm")
//	    public String userShowBusInformation(HttpServletRequest request,BusDao busDao) throws BusException{
//	        List<Bus> busList = busDao.getAll();
//	        request.setAttribute("busList", busList);
//	        return "viewBusDataUser";
//	    }
    
//	@GetMapping("createBus.htm")
//    public String adminstrativeCreateBusForm(ModelMap model, Bus bus) {
//
//        model.addAttribute("bus", bus);
//        return "AdminAddBusData";
//    }
//    
//
//    @PostMapping("createBus.htm")
//    public String adminstrativeHandleCreateBusForm(ModelMap model, @ModelAttribute("bus") Bus bus, BindingResult result, SessionStatus status, BusDao busDao) throws BusException {
//
//        if (result.hasErrors()) {
//            return "AdminAddBusData";
//        } else {
//            Bus alreadyBus = busDao.get(bus);
//            if (alreadyBus == null) {
//                busDao.create(bus);
//                status.setComplete();
//                return "AdminBusDataAdded";
//            } else {
//                model.addAttribute("bus", alreadyBus);
//                return "AdminBusError";
//            }
//        }
//    }
    
}
