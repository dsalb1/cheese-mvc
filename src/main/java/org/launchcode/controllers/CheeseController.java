package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseType;
import org.launchcode.models.Data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    // Request path: /cheese/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    //binds and validates cheese object from user input
    //Spring calls object using input from add fields
    public String processAddCheeseForm(Model model, @ModelAttribute @Valid Cheese newCheese, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }
        cheeseDao.save(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            cheeseDao.delete(cheeseId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {
        Cheese theCheese = cheeseDao.findOne(cheeseId);
        model.addAttribute("cheese", theCheese);
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("title", "Edit cheese: " + theCheese.getName());

        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    //Spring calls Cheese object based on input from edit fields
    public String processEditForm(Model model, @ModelAttribute @Valid Cheese theCheese, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Cheese: " + theCheese.getName());
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        } else {

            Cheese ch = cheeseDao.findOne(theCheese.getId());
            ch.setName(theCheese.getName());
            ch.setDescription(theCheese.getDescription());
            ch.setRating(theCheese.getRating());
            ch.setType(theCheese.getType());



            model.addAttribute("cheeses", cheeseDao.findAll());

            return "cheese/index";
        }
    }
}
