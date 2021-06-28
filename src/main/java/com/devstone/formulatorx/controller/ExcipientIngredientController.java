package com.devstone.formulatorx.controller;

import com.devstone.formulatorx.model.ExcipientIngredient;
import com.devstone.formulatorx.model.Manufacturer;
import com.devstone.formulatorx.service.ExcipientIngredientService;
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
@RequestMapping("/excipients")
public class ExcipientIngredientController {

    @Autowired
    private ExcipientIngredientService excipientIngredientService;
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/listExc")
    public String listExcipients(Model model) {
        List<ExcipientIngredient> theExcipient = excipientIngredientService.findAll();
        //add list to the model.
        model.addAttribute("excipient", theExcipient);
        //return the thymeleaf page with this path.
        return "list-excipients";
    }

    @GetMapping("/addExcipientForm")
    public String addForm(Model model){
        //to add a new excipient ingredient, need to create a new object
        ExcipientIngredient excipientIngredient = new ExcipientIngredient();
        Manufacturer manufacturer = new Manufacturer();

        //add to the model
        model.addAttribute("excipientIngredient", excipientIngredient);
        model.addAttribute("manufacturer", manufacturer);

        return "add-excipient-form";
    }

    @PostMapping("/saveExc")
    public String saveExcipients(@ModelAttribute("excipientIngredient") ExcipientIngredient excipientIngredient, @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        // save the Ingredient
        excipientIngredientService.saveOrUpdate(excipientIngredient);
        manufacturerService.save(manufacturer);

        // use a redirect to prevent duplicate submissions
        return "redirect:/excipients/listExc";
    }
}
