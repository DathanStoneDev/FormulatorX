package com.devstone.formulatorx.dao;

import com.devstone.formulatorx.model.ExcipientIngredient;
import java.util.List;

public interface ExcipientIngredientDAO {

    List<ExcipientIngredient> findAll();
    ExcipientIngredient findById(int theId);
    void saveOrUpdate(ExcipientIngredient excipientIngredient);
    void deleteById(int theId);
}
