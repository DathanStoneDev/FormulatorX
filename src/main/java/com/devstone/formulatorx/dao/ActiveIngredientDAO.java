package com.devstone.formulatorx.dao;

import com.devstone.formulatorx.model.ActiveIngredient;
import java.util.List;

public interface ActiveIngredientDAO {

    List<ActiveIngredient> findAll();
    ActiveIngredient findById(int theId);
    void save(ActiveIngredient newIngredient);
    void deleteById(int theId);
}
