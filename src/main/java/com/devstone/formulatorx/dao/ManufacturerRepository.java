package com.devstone.formulatorx.dao;

import com.devstone.formulatorx.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
