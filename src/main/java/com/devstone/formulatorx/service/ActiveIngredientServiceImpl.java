package com.devstone.formulatorx.service;

import com.devstone.formulatorx.dao.ActiveIngredientDAO;
import com.devstone.formulatorx.dao.ActiveIngredientDAOImpl;
import com.devstone.formulatorx.model.ActiveIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActiveIngredientServiceImpl implements ActiveIngredientService {

    private final ActiveIngredientDAO activeIngredientDAO;

    public ActiveIngredientServiceImpl(ActiveIngredientDAO activeIngredientDAO) {
        this.activeIngredientDAO = activeIngredientDAO;
    }

    @Override
    @Transactional
    public List<ActiveIngredient> findAll() {
        return activeIngredientDAO.findAll();
    }

    @Override
    @Transactional
    public ActiveIngredient findById(int theId) {
        Optional<ActiveIngredient> result = Optional.ofNullable(activeIngredientDAO.findById(theId));

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
    @Transactional
    public void save(ActiveIngredient theActiveIngredient) {
        activeIngredientDAO.save(theActiveIngredient);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        activeIngredientDAO.deleteById(theId);
    }
}
