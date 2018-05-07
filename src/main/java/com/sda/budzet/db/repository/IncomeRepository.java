package com.sda.budzet.db.repository;

import com.sda.budzet.db.model.Category;
import com.sda.budzet.db.model.Income;
import com.sda.budzet.dto.IncomeOutput;

import java.util.List;

public interface IncomeRepository {
    void save(Income income);
    List<Category> getCategoryList();
    List<Income> getIncomeList();
    List<IncomeOutput> getIncomeOutput();
}
