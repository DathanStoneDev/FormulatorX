package com.devstone.formulatorx.dao;

import com.devstone.formulatorx.model.ActiveIngredient;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ActiveIngredientDAOImpl implements ActiveIngredientDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ActiveIngredient> findAll() {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<ActiveIngredient> theQuery =
                currentSession.createQuery("from ActiveIngredient ", ActiveIngredient.class);
        //execute the query and grab the result list
        List<ActiveIngredient> ingredients = theQuery.getResultList();
        //return results
        return ingredients;
    }

    @Override
    public ActiveIngredient findById(int theId) {

        //get the current session
        Session currentSession = entityManager.unwrap(Session.class);
        //get the employee
        ActiveIngredient ingredients = currentSession.get(ActiveIngredient.class, theId);
        //return employee
        return ingredients;
    }

    @Override
    public void save(ActiveIngredient activeIngredient) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(activeIngredient);
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery("delete from ActiveIngredient where id=:activeId");

        theQuery.setParameter("activeId", theId);

        theQuery.executeUpdate();
    }

}
