package com.devstone.formulatorx.service;

import com.devstone.formulatorx.dao.ManufacturerDAO;
import com.devstone.formulatorx.model.Manufacturer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerDAO manufacturerDAO;

    public ManufacturerServiceImpl(ManufacturerDAO manufacturerDAO) {
        this.manufacturerDAO = manufacturerDAO;
    }

    @Override
    @Transactional
    public void save(Manufacturer manufacturer) {
        manufacturerDAO.save(manufacturer);
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerDAO.findAll();
    }

    @Override
    public Manufacturer findById(int theId) {
        Optional<Manufacturer> result = Optional.ofNullable(manufacturerDAO.findById(theId));

        Manufacturer manufacturer;
        if(result.isPresent()) {
            manufacturer = result.get();
        }
        else {
            throw new RuntimeException("Did not find the active ingredient id - " + theId);
        }
        return manufacturer;
    }

    @Override
    public void deleteById(int theId) {

    }

}
