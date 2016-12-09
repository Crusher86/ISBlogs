package ru.innopolis.isblogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.isblogs.model.entity.Profile;
import ru.innopolis.isblogs.model.models.UserModel;
import ru.innopolis.isblogs.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getMainPage() {
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String getLoginForm(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        return "login";
    }

    @GetMapping(value = "/registration")
    public ModelAndView regForm(){
        ModelAndView model = new ModelAndView("registration");
        model.addObject("userModel", new UserModel());
        model.addObject("profile", new Profile());
        return model;
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("userModel")UserModel userModel,
                               BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return "registration";
        }
        return userService.getAddUser(userModel);
    }
}
