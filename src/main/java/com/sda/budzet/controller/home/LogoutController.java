package com.sda.budzet.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage(@RequestParam(name = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("logout");
        if (error != null) {
            modelAndView.addObject("errorMsg", true);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String processRegistration(
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
            HttpSession session = request.getSession();
            session.invalidate();
            return "redirect:./";
    }
}


