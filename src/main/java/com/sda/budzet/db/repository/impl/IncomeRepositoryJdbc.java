package com.sda.budzet.db.repository.impl;


import com.sda.budzet.db.model.Category;
import com.sda.budzet.db.model.Income;
import com.sda.budzet.db.repository.IncomeRepository;
import com.sda.budzet.dto.IncomeOutput;
import com.sda.budzet.dto.OutgoingsOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("incomeRepositoryJdbc")
public class IncomeRepositoryJdbc implements IncomeRepository {

    private static final String INSERT_SQL = "INSERT INTO income(idUser, categoryID,incomeName,incomeAmount,addDate) " +
            "VALUES ('%d','%d','%s','%d','%s')";

    private final static String SELECT_ALL_INCOME = "SELECT * FROM income";
    private final static String SELECT_ALL = "SELECT * FROM category WHERE categoryType='wpłata'";
    private final static String SELECT_INCOME2 = "SELECT category.CategoryName,income.incomeName,income.incomeAmount,income.addDate" +
            " FROM income INNER JOIN category ON (income.categoryID=category.categoryID)";

    private BeanPropertyRowMapper<Income> mapper = new BeanPropertyRowMapper<>(Income.class);
    private BeanPropertyRowMapper<Category> mapper2 = new BeanPropertyRowMapper<>(Category.class);
    private BeanPropertyRowMapper<IncomeOutput> mapper3 = new BeanPropertyRowMapper<>(IncomeOutput.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Income income) {
        jdbcTemplate.execute(String.format(INSERT_SQL, income.getIdUser(),
                income.getCategoryID(), income.getIncomeName(), income.getIncomeAmount(), income.getAddDate()));
    }

    @Override
    public List<Category> getCategoryList() {
        return jdbcTemplate.query(SELECT_ALL, mapper2);
    }

    @Override
    public List<Income> getIncomeList() {
        return jdbcTemplate.query(SELECT_ALL_INCOME, mapper);
    }

    @Override
    public List<IncomeOutput> getIncomeOutput() {
        return jdbcTemplate.query(SELECT_INCOME2,mapper3);
    }



}

