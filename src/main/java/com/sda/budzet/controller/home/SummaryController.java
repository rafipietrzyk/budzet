package com.sda.budzet.controller.home;

import com.sda.budzet.db.model.Income;
import com.sda.budzet.db.model.Outgoings;
import com.sda.budzet.dto.IncomeOutput;
import com.sda.budzet.dto.OutgoingsOutput;
import com.sda.budzet.service.IncomeService;
import com.sda.budzet.service.OutgoingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SummaryController {

    @Autowired
    private OutgoingsService outgoingsService;
    @Autowired
    private IncomeService incomeService;



    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public ModelAndView summaryPage(@RequestParam(name = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("summary");
        List<Outgoings> outgoings = outgoingsService.getOutgoings();
        modelAndView.addObject("outgoings", outgoings);
        List<Income> income= incomeService.getIncome();
        modelAndView.addObject("income",income);
        List<OutgoingsOutput> outgoingsOutputs=outgoingsService.getOutgoingsOutput();
        modelAndView.addObject("outgoingsOutputs",outgoingsOutputs);
        List<IncomeOutput> incomeOutput=incomeService.getIncomeOutput();
        modelAndView.addObject("incomeOutput",incomeOutput);

        int sumIncome = 0;
        for (Income inc : income) {
            sumIncome += inc.getIncomeAmount();
        }

        int sumOutgoings = 0;
        for (Outgoings out : outgoings) {
            sumOutgoings += out.getOutgoingsAmount();
        }

        int sumBalance;
        sumBalance = sumIncome+sumOutgoings;

        modelAndView.addObject("sumIncome",sumIncome);
        modelAndView.addObject("sumOutgoings",sumOutgoings);
        modelAndView.addObject("sumBalance",sumBalance);

        if (error != null) {
            modelAndView.addObject("errorMsg", true);
        }

        return modelAndView;
    }

}
