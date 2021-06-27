package com.devstone.formulatorx.dao;

import com.devstone.formulatorx.model.Manufacturer;
import java.util.List;


public interface ManufacturerDAO {
    void saveOrUpdate(Manufacturer manufacturer);
    List<Manufacturer> findAll();
    Manufacturer findById(int theId);
    void deleteById(int theId);

}
