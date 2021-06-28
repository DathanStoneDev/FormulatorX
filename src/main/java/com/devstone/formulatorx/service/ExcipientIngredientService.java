package com.devstone.formulatorx.service;

import com.devstone.formulatorx.model.ExcipientIngredient;
import java.util.List;

public interface ExcipientIngredientService {

    List<ExcipientIngredient> findAll();
    ExcipientIngredient findById(int theId);
    void saveOrUpdate(ExcipientIngredient excipientIngredient);
    void deleteById(int theId);
}
