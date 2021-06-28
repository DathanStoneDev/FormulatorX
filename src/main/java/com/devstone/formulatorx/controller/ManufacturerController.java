package com.devstone.formulatorx.controller;

import com.devstone.formulatorx.model.Manufacturer;
import com.devstone.formulatorx.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    ManufacturerService manufacturerService;

    @GetMapping("/list")
    public String listManufacturers(Model model) {
        List<Manufacturer> theManufacturer = manufacturerService.findAllManufacturers();
        //add list to the model.
        model.addAttribute("manufacturer", theManufacturer);
        //return the thymeleaf page with this path.
        return "list-manufacturers";
    }

    @GetMapping("/addForm")
    public String addForm(Model model){
        //to add a new active ingredient, need to create a new object
        Manufacturer theManufacturer = new Manufacturer();

        //add to the model
        model.addAttribute("manufacturer", theManufacturer);

        return "add-form";
    }

    @PostMapping("/save")
    public String saveManufacturers(@ModelAttribute("manufacturer") Manufacturer manufacturer) {

        // save the Ingredient
        manufacturerService.addManufacturer(manufacturer);

        // use a redirect to prevent duplicate submissions
        return "redirect:/manufacturers/list";
    }

}
