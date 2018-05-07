package com.sda.budzet.db.repository.impl;

import com.sda.budzet.db.model.Category;
import com.sda.budzet.db.model.Outgoings;
import com.sda.budzet.db.repository.OutgoingsRepository;
import com.sda.budzet.dto.OutgoingsOutput;
import com.sda.budzet.utils.StaticValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Repository("outgoingsRepositoryJdbc")
public class OutgoingsJdbc implements OutgoingsRepository {


    private static final String INSERT_SQL = "INSERT INTO outgoings(UserID,categoryID,outgoingsName, outgoingsAmount, addDate) " +
            "VALUES ('%d','%d', '%s','%d','%s')";
    private final static String SELECT_ALL = "SELECT * FROM category WHERE categoryType= 'wydatek'";
    private final static String SELECT_ALL_OUTGOINGS = "SELECT * FROM outgoings";

    private final static String SELECT_OUTGOINGS2 = "SELECT category.CategoryName,outgoings.outgoingsName,outgoings.outgoingsAmount,outgoings.addDate" +
             " FROM outgoings INNER JOIN category ON (outgoings.categoryID=category.categoryID)";
    private BeanPropertyRowMapper<Category> mapper = new BeanPropertyRowMapper<>(Category.class);
    private BeanPropertyRowMapper<Outgoings> mapper2 = new BeanPropertyRowMapper<>(Outgoings.class);
    private BeanPropertyRowMapper<OutgoingsOutput> mapper3 = new BeanPropertyRowMapper<>(OutgoingsOutput.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Outgoings outgoings) {
        jdbcTemplate.execute(String.format(INSERT_SQL, outgoings.getUserID(),
                outgoings.getCategoryID(), outgoings.getOutgoingsName(),outgoings.getOutgoingsAmount()*(-1), outgoings.getAddDate()));
    }


    @Override
    public List<Category> getCategoryList() {
        return  jdbcTemplate.query(SELECT_ALL, mapper);
    }

    @Override
    public List<Outgoings> getOutgoingsList() {

      return  jdbcTemplate.query(SELECT_ALL_OUTGOINGS,mapper2);
    }

    @Override
    public List<OutgoingsOutput> getOutgoingsOutput() {
        return jdbcTemplate.query(SELECT_OUTGOINGS2,mapper3);
    }
}
