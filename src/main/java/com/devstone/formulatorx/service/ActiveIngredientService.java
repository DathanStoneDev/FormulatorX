package com.devstone.formulatorx.service;

import com.devstone.formulatorx.model.ActiveIngredient;

import java.util.List;

public interface ActiveIngredientService {

    List<ActiveIngredient> findAll();
    ActiveIngredient findById(int theId);
    void save(ActiveIngredient theActiveIngredient);
    void deleteById(int theId);
}
