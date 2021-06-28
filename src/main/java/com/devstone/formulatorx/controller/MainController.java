package com.devstone.formulatorx.controller;

import com.devstone.formulatorx.model.ActiveIngredient;
import com.devstone.formulatorx.model.ExcipientIngredient;
import com.devstone.formulatorx.model.Manufacturer;
import com.devstone.formulatorx.service.ActiveService;
import com.devstone.formulatorx.service.ExcipientService;
import com.devstone.formulatorx.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/formulaX")
public class MainController {

    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private ExcipientService excipientService;
    @Autowired
    private ActiveService activeService;

    @GetMapping("/listManufacturers")
    public String listManufacturers(Model model) {
        List<Manufacturer> theManufacturer = manufacturerService.findAllManufacturers();
        //add list to the model.
        model.addAttribute("manufacturer", theManufacturer);
        //return the thymeleaf page with this path.
        return "list-manufacturers";
    }

    @GetMapping("/listIngredients")
    public String listIngredients(Model model) {
        List<ActiveIngredient> theActive = activeService.findAllActives();
        List<ExcipientIngredient> theExcipient = excipientService.findAllExcipients();
        //add list to the model.
        model.addAttribute("active", theActive);
        model.addAttribute("excipient", theExcipient);
        //return the thymeleaf page with this path.
        return "list-all-ingredients";
    }

    @GetMapping("/addExcipientForm")
    public String addExcForm(Model model){
        //to add a new excipient ingredient, need to create a new object
        ExcipientIngredient excipientIngredient = new ExcipientIngredient();
        Manufacturer manufacturer = new Manufacturer();

        //add to the model
        model.addAttribute("excipientIngredient", excipientIngredient);
        model.addAttribute("manufacturer", manufacturer);

        return "add-excipient-form";
    }

    @GetMapping("/addActiveForm")
    public String addActForm(Model model){
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
        activeService.addActive(activeIngredient);
        manufacturerService.addManufacturer(manufacturer);

        // use a redirect to prevent duplicate submissions
        return "redirect:/formulaX/listIngredients";
    }

    @PostMapping("/saveExc")
    public String saveExcipients(@ModelAttribute("excipientIngredient") ExcipientIngredient excipientIngredient, @ModelAttribute("manufacturer") Manufacturer manufacturer) {

        // save the Ingredient
        excipientService.addExcipient(excipientIngredient);
        manufacturerService.addManufacturer(manufacturer);

        // use a redirect to prevent duplicate submissions
        return "redirect:/formulaX/listIngredients";
    }

    @GetMapping("/showActiveUpdateForm")
    public String showFormForActUpdate(@RequestParam("activeId") Integer theId,
                                    Model theModel) {
        //get employee from service
        Optional<ActiveIngredient> activeIngredient = activeService.getActive(theId);
        //set employee as attribute
        theModel.addAttribute("activeIngredient", activeIngredient);
        //send over to form

        return "add-active-form";
    }

    @GetMapping("/showExcipientUpdateForm")
    public String showFormForExcUpdate(@RequestParam("excipientId") Integer theId,
                                    Model theModel) {
        //get employee from service
        Optional<ExcipientIngredient> excipientIngredient = excipientService.getExcipient(theId);
        //set employee as attribute
        theModel.addAttribute("excipientIngredient", excipientIngredient);
        //send over to form

        return "add-active-form";
    }

    @GetMapping("/deleteAct")
    public String deleteAct(@RequestParam("activeId") Integer theId,
                         Model theModel) {
        //delete employee
        activeService.deleteActive(theId);
        //redirect
        return "redirect:/formulaX/listIngredients";
    }

    @GetMapping("/deleteExc")
    public String deleteExc(@RequestParam("excipientId") Integer theId,
                         Model theModel) {
        //delete employee
        excipientService.deleteExcipient(theId);
        //redirect
        return "redirect:/formulaX/listIngredients";
    }



}
