package com.devstone.formulatorx.service;

import com.devstone.formulatorx.dao.ManufacturerRepository;
import com.devstone.formulatorx.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAllManufacturers() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturerRepository.findAll().forEach(manufacturers::add);
        return manufacturers;
    }

    public Optional<Manufacturer> getManufacturer(Integer id) { return manufacturerRepository.findById(id);
    }

    //saves or updates manufacturer
    public void addManufacturer(Manufacturer manufacturer) { manufacturerRepository.save(manufacturer);
    }

    public void deleteManufacturer(Integer id) {
        manufacturerRepository.deleteById(id);
    }
}
