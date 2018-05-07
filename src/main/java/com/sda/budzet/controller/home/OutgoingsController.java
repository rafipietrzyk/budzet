package com.sda.budzet.controller.home;

import com.sda.budzet.db.model.Category;
import com.sda.budzet.dto.LoginForm;
import com.sda.budzet.dto.OutgoingsForm;
import com.sda.budzet.service.OutgoingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class OutgoingsController {

    @Autowired
    private OutgoingsService outgoingsService;

    @RequestMapping(value = "/outgoings", method = RequestMethod.GET)
    public ModelAndView outgoingsPage(@RequestParam(name = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("outgoings");
        List<Category> categories = outgoingsService.getCategory();
        modelAndView.addObject("category", categories);
        if (error != null) {
            modelAndView.addObject("errorMsg", true);
        }

        return modelAndView;
    }


    @RequestMapping(value = "/outgoings", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute(value = "regForm") OutgoingsForm form,
                                      HttpServletRequest request){
        Integer userId = (Integer) request.getSession().getAttribute("UserID");
        form.setUserID(userId);
        outgoingsService.outgoings(form);
            return "redirect:./outgoings?error=true";
    }
}

