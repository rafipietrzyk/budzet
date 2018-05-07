package com.sda.budzet.controller.home;


import com.sda.budzet.db.model.Category;
import com.sda.budzet.dto.IncomeForm;
import com.sda.budzet.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @RequestMapping(value = "/income", method = RequestMethod.GET)
    public ModelAndView incomePage(@RequestParam(name = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("income");
        List<Category> categories = incomeService.getCategory();
        modelAndView.addObject("category", categories);
        if(error != null){
            modelAndView.addObject("errorMsg", true);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/income", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute(value = "regForm") IncomeForm form,
                                      HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("UserID");
        form.setIdUser(userId);

        incomeService.income(form);


        return "redirect:./income?error=true";
    }
}