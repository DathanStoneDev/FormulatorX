package com.devstone.formulatorx.dao;

import com.devstone.formulatorx.model.ExcipientIngredient;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ExcipientIngredientDAOImpl implements ExcipientIngredientDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ExcipientIngredient> findAll() {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<ExcipientIngredient> theQuery =
                currentSession.createQuery("from ExcipientIngredient", ExcipientIngredient.class);
        //execute the query and grab the result list
        List<ExcipientIngredient> excIngredients = theQuery.getResultList();
        //return results
        return excIngredients;
    }

    @Override
    public ExcipientIngredient findById(int theId) {

        //get the current session
        Session currentSession = entityManager.unwrap(Session.class);
        //get the employee
        ExcipientIngredient excIngredients = currentSession.get(ExcipientIngredient.class, theId);
        //return employee
        return excIngredients;
    }

    @Override
    public void saveOrUpdate(ExcipientIngredient excipientIngredient) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(excipientIngredient);
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery("delete from ExcipientIngredient where id=:excId");

        theQuery.setParameter("excId", theId);

        theQuery.executeUpdate();
    }

}
