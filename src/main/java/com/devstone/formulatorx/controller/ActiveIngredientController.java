package com.devstone.formulatorx.controller;


import com.devstone.formulatorx.model.ActiveIngredient;
import com.devstone.formulatorx.model.Manufacturer;
import com.devstone.formulatorx.service.ActiveIngredientService;
import com.devstone.formulatorx.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/actives")
public class ActiveIngredientController {

   @Autowired
   private ActiveIngredientService activeIngredientService;

   @Autowired
   private ManufacturerService manufacturerService;

    //getting a full list of active ingredients using the service
    @GetMapping("/listAct")
    public String listActives(Model model) {
        List<ActiveIngredient> theActive = activeIngredientService.findAll();
        //add list to the model.
        model.addAttribute("active", theActive);
        //return the thymeleaf page with this path.
        return "list-actives";
    }

    @GetMapping("/addActiveForm")
    public String addForm(Model model){
        //to add a new active ingredient, need to create a new object
        ActiveIngredient activeIngredient = new ActiveIngredient();
        Manufacturer manufacturer = new Manufacturer();

        //add to the model
        model.addAttribute("activeIngredient", activeIngredient);
        model.addAttribute("manufacturer", manufacturer);

        return "add-active-form";
    }

    @PostMapping("/saveAct")
    public String saveActives(@ModelAttribute("activeIngredient") ActiveIngredient activeIngredient, @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        // save the Ingredient
        activeIngredientService.save(activeIngredient);
        manufacturerService.save(manufacturer);

        // use a redirect to prevent duplicate submissions
        return "redirect:/actives/listAct";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("activeId") int theId,
                                    Model theModel) {
        //get employee from service
        ActiveIngredient activeIngredient = activeIngredientService.findById(theId);
        //set employee as attribute
        theModel.addAttribute("activeIngredient", activeIngredient);
        //send over to form

        return "add-active-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("activeId") int theId,
                         Model theModel) {
        //delete employee
        activeIngredientService.deleteById(theId);
        //redirect
        return "redirect:/actives/listAct";
    }
}
