package com.devstone.formulatorx.service;

import com.devstone.formulatorx.model.Manufacturer;
import java.util.List;

public interface ManufacturerService {
    void saveOrUpdate(Manufacturer manufacturer);
    List<Manufacturer> findAll();
    Manufacturer findById(int theId);
    void deleteById(int theId);
}
