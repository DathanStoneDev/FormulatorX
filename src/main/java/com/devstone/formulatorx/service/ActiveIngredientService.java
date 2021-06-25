package com.devstone.formulatorx.service;

import com.devstone.formulatorx.model.ActiveIngredient;

import java.util.List;

public interface ActiveIngredientService {

    public List<ActiveIngredient> findAll();
    public ActiveIngredient findById(int theId);
    public void save(ActiveIngredient theActiveIngredient);
    public void deleteById(int theId);
}
