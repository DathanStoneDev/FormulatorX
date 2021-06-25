package com.devstone.formulatorx.service;

import com.devstone.formulatorx.dao.ActiveIngredientsRepository;
import com.devstone.formulatorx.model.ActiveIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ActiveIngredientServiceImpl implements ActiveIngredientService {

    private ActiveIngredientsRepository activeIngredientsRepository;

    @Autowired
    public ActiveIngredientServiceImpl(ActiveIngredientsRepository theActiveIngredientRepository) {
        activeIngredientsRepository = theActiveIngredientRepository;
    }
    //no need to list transactional as it is already added out of the box by JPA repo
    @Override
    public List<ActiveIngredient> findAll() {
        return activeIngredientsRepository.findAll();
    }

    @Override
    public ActiveIngredient findById(int theId) {
        Optional<ActiveIngredient> result = activeIngredientsRepository.findById(theId);

        ActiveIngredient theActiveIngredient;
        if(result.isPresent()) {
           theActiveIngredient = result.get();
        }
        else {
            throw new RuntimeException("Did not find the active ingredient id - " + theId);
        }
        return theActiveIngredient;
    }

    @Override
    public void save(ActiveIngredient theActiveIngredient) {
        activeIngredientsRepository.save(theActiveIngredient);
    }

    @Override
    public void deleteById(int theId) {
        activeIngredientsRepository.deleteById(theId);
    }
}
