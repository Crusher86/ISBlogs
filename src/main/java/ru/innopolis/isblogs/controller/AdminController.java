package ru.innopolis.isblogs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AdminController {


    @GetMapping(value = "/admin")
    public ModelAndView getLoginForm() {
//        List<User> users = null;
        ModelAndView modelAndView = new ModelAndView("/admin");
//        try {
//            users = usersDao.getAll();
//            modelAndView.addObject("users", users);
//        } catch (ApplicationException e) {
//            modelAndView.addObject("message", e.getMessage());
//        }
        return modelAndView;
    }
}
