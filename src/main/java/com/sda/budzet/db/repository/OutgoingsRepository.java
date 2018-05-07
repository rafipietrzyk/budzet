package com.sda.budzet.db.repository;


import com.sda.budzet.db.model.Category;
import com.sda.budzet.db.model.Outgoings;
import com.sda.budzet.dto.OutgoingsOutput;

import java.util.List;

public interface OutgoingsRepository {
    void save(Outgoings outgoings);
    List<Category> getCategoryList();
    List<Outgoings> getOutgoingsList();
    List<OutgoingsOutput> getOutgoingsOutput();


}
