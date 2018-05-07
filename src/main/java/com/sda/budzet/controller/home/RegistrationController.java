package com.sda.budzet.controller.home;

import com.sda.budzet.dto.RegistrationForm;
import com.sda.budzet.service.UsersService;
import com.sda.budzet.utils.StaticValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage(@RequestParam(name = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("register");
        if(error != null){
            modelAndView.addObject("errorMsg", true);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute(value = "regForm") RegistrationForm form) {
        if (!form.isValid() || usersService.isLoginExists(form.getLogin())){
            return "redirect:./register?error=true";
        }

        usersService.register(form);


        return "redirect:./?result="+ StaticValues.REGISTRATION_SUCCESS;
    }
}
