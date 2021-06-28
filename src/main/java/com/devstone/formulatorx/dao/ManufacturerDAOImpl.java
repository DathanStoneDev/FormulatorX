package com.devstone.formulatorx.dao;

import com.devstone.formulatorx.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Manufacturer manufacturer) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(manufacturer);
    }

    @Override
    public List<Manufacturer> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<Manufacturer> theQuery =
                currentSession.createQuery("from Manufacturer ", Manufacturer.class);
        //execute the query and grab the result list
        List<Manufacturer> manufacturers = theQuery.getResultList();
        //return results
        return manufacturers;
    }

    @Override
    public Manufacturer findById(int theId) {

        //get the current session
        Session currentSession = entityManager.unwrap(Session.class);
        //get the employee
        Manufacturer manufacturers = currentSession.get(Manufacturer.class, theId);
        //return employee
        return manufacturers;
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery("delete from Manufacturer where id=:manId");

        theQuery.setParameter("manId", theId);

        theQuery.executeUpdate();
    }
}
