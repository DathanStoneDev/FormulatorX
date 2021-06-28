package com.devstone.formulatorx.service;

import com.devstone.formulatorx.dao.ExcipientIngredientRepository;
import com.devstone.formulatorx.model.ExcipientIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ExcipientService {

    @Autowired
    private ExcipientIngredientRepository excipientIngredientRepository;

    public List<ExcipientIngredient> findAllExcipients() {
        List<ExcipientIngredient> excipientIngredients = new ArrayList<>();
        excipientIngredientRepository.findAll().forEach(excipientIngredients::add);
        return excipientIngredients;
    }

    public Optional<ExcipientIngredient> getExcipient(Integer id) {
        return excipientIngredientRepository.findById(id);
    }

    //saves or updates excipient
    public void addExcipient(ExcipientIngredient excipientIngredients) {
        excipientIngredientRepository.save(excipientIngredients);
    }

    public void deleteExcipient(Integer id) {excipientIngredientRepository.deleteById(id);
    }
}
