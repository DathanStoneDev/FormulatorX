package com.devstone.formulatorx;

import com.devstone.formulatorx.dao.ActiveIngredientsRepository;
import com.devstone.formulatorx.model.ActiveIngredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ActiveIngredientRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ActiveIngredientsRepository activeIngredientsRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfIngredients() {
        activeIngredientsRepository.save(new ActiveIngredient("Best Vitamin C", "Vitamin C", 76.5));
        List<ActiveIngredient> ingredients = (List<ActiveIngredient>) activeIngredientsRepository.findAll();

        assertThat(ingredients.size()).isEqualTo(3);
    }
}
