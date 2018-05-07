package com.sda.budzet.service;

import com.sda.budzet.db.model.Category;
import com.sda.budzet.db.model.Income;
import com.sda.budzet.db.model.Outgoings;
import com.sda.budzet.db.repository.IncomeRepository;
import com.sda.budzet.dto.IncomeForm;
import com.sda.budzet.dto.IncomeOutput;
import com.sda.budzet.dto.OutgoingsOutput;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IncomeService {

    @Resource(name = "incomeRepositoryJdbc")
    private IncomeRepository incomeRepository;

    public List<Category> getCategory(){
        return incomeRepository.getCategoryList();
    }
    public List<Income> getIncome(){return incomeRepository.getIncomeList();}
    public List<IncomeOutput> getIncomeOutput(){
        return incomeRepository.getIncomeOutput();
    }

    public void income(IncomeForm form){
        Income income = new Income();
        income.setIdUser(form.getIdUser());
        income.setCategoryID(form.getCategoryID());
        income.setIncomeName(form.getIncomeName());
        income.setIncomeAmount(form.getIncomeAmount());
        income.setAddDate(form.getAddDate());
        incomeRepository.save(income);
    }

}
