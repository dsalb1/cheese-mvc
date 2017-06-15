package org.launchcode.controllers;

import org.launchcode.models.Data.CheeseDao;
import org.launchcode.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Dan on 6/5/2017.
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "User Signup");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors) {



        if (errors.hasErrors()) {
            user.setPassword("");
            model.addAttribute("title", "User Signup");
            model.addAttribute(user);
            return "user/add";
        }

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("greeting", "Welcome " + user.getUsername() + "!");
        return "cheese/index";


    }
}
