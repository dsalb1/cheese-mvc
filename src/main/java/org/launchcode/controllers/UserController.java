package org.launchcode.controllers;

import org.launchcode.models.CheeseData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dan on 6/5/2017.
 */

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "User Signup");

        return "user/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, @RequestParam String verify) {
        String psw = user.getPassword();

        if (psw.equals(verify)) {
            model.addAttribute("cheeses", CheeseData.getAll());
            model.addAttribute("greeting", "Welcome " + user.getUsername() + "!");
            return "cheese/index";
        } else {
            model.addAttribute("title", "User Signup");
            return "user/add";
        }
    }
}
