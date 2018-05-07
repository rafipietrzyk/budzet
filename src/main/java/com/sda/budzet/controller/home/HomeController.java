package com.sda.budzet.controller.home;

import com.sda.budzet.utils.StaticValues;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView homePage(@RequestParam(name = "result", required = false) String operationResult) {
        ModelAndView modelAndView = new ModelAndView();
        if(operationResult != null){
            switch (operationResult){
                case StaticValues.REGISTRATION_SUCCESS:
                    modelAndView.addObject("registrationComplete", true);
                    break;
                default:
                    break;
            }
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
