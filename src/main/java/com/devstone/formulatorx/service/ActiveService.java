package com.devstone.formulatorx.service;

import com.devstone.formulatorx.dao.ActiveIngredientRepository;
import com.devstone.formulatorx.model.ActiveIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ActiveService {

    @Autowired
    private ActiveIngredientRepository activeIngredientRepository;

    public List<ActiveIngredient> findAllActives() {
        List<ActiveIngredient> actives = new ArrayList<>();
        activeIngredientRepository.findAll().forEach(actives::add);
        return actives;
    }

    public Optional<ActiveIngredient> getActive(Integer id) {
        return activeIngredientRepository.findById(id);
    }

    //saves or updates active ingredients
    public void addActive(ActiveIngredient activeIngredient) {
        activeIngredientRepository.save(activeIngredient);
    }

    public void deleteActive(Integer id) { activeIngredientRepository.deleteById(id);
    }
}
