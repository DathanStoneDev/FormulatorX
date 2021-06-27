package com.devstone.formulatorx.controller;


import com.devstone.formulatorx.model.ActiveIngredient;
import com.devstone.formulatorx.service.ActiveIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/actives")
public class ActiveIngredientController {

    //injecting service
    @Autowired
    private ActiveIngredientService activeIngredientService;

    //getting a full list of active ingredients using the service
    @GetMapping("/list")
    public String listActives(Model model) {
        List<ActiveIngredient> theActive = activeIngredientService.findAll();
        //add list to the model.
        model.addAttribute("active", theActive);
        //return the thymeleaf page with this path.
        return "list-actives";
    }

    @GetMapping("/addForm")
    public String addForm(Model model){
        //to add a new active ingredient, need to create a new object
        ActiveIngredient newIngredient = new ActiveIngredient();

        //add to the model
        model.addAttribute("activeIngredient", newIngredient);

        return "add-active-form";
    }

    @PostMapping("/save")
    public String saveActives(@ModelAttribute("activeIngredient") ActiveIngredient newIngredient) {

        // save the employee
        activeIngredientService.save(newIngredient);

        // use a redirect to prevent duplicate submissions
        return "redirect:/actives/list";
    }
}