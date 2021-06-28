package com.devstone.formulatorx.service;

import com.devstone.formulatorx.dao.ActiveIngredientDAO;
import com.devstone.formulatorx.dao.ExcipientIngredientDAO;
import com.devstone.formulatorx.dao.ExcipientIngredientDAOImpl;
import com.devstone.formulatorx.model.ActiveIngredient;
import com.devstone.formulatorx.model.ExcipientIngredient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ExcipientIngredientServiceImpl implements ExcipientIngredientService {

    private final ExcipientIngredientDAO excipientIngredientDAO;

    public ExcipientIngredientServiceImpl(ExcipientIngredientDAO excipientIngredientDAO) {
        this.excipientIngredientDAO = excipientIngredientDAO;
    }

    @Override
    @Transactional
    public List<ExcipientIngredient> findAll() {
        return excipientIngredientDAO.findAll();
    }

    @Override
    @Transactional
    public ExcipientIngredient findById(int theId) {
        Optional<ExcipientIngredient> result = Optional.ofNullable(excipientIngredientDAO.findById(theId));

        ExcipientIngredient excipientIngredient;
        if(result.isPresent()) {
           excipientIngredient = result.get();
        }
        else {
            throw new RuntimeException("Did not find the active ingredient id - " + theId);
        }
        return excipientIngredient;
    }

    @Override
    @Transactional
    public void saveOrUpdate(ExcipientIngredient excipientIngredient) {
        excipientIngredientDAO.saveOrUpdate(excipientIngredient);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        excipientIngredientDAO.deleteById(theId);
    }
}
