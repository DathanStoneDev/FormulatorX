package com.devstone.formulatorx.dao;

import com.devstone.formulatorx.model.ActiveIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveIngredientsRepository extends JpaRepository<ActiveIngredient, Integer> {
}
