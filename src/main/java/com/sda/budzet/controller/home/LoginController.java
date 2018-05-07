package com.sda.budzet.controller.home;

import com.sda.budzet.db.model.User;
import com.sda.budzet.dto.LoginForm;
import com.sda.budzet.service.UsersService;
import com.sda.budzet.utils.StaticValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(name = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("login");
        if(error != null){
            modelAndView.addObject("errorMsg", true);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute(value = "loginForm") LoginForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        if (!form.isValid()){
            return "redirect:./login?error=true";
        }

        User user = usersService.login(form);
        if (user != null){
            //Otwieramy sesję użytkownika
            HttpSession session = request.getSession();
            session.setAttribute(StaticValues.SESSION_USER_KEY, user.getLogin());
            session.setAttribute("UserID",user.getId());
            //Ustawiamy czas trwania sesji za pomocą ciasteczka
            Cookie cookie = new Cookie(StaticValues.SESSION_TIME_KEY, "");
            cookie.setMaxAge(120);
            response.addCookie(cookie);

            return "redirect:./";
        }else{
            return "redirect:./login?error=true";
        }


    }
}
