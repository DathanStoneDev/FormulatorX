package com.devstone.formulatorx.controller;


import com.devstone.formulatorx.model.ActiveIngredient;
import com.devstone.formulatorx.service.ActiveIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
