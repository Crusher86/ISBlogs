package ru.innopolis.isblogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.isblogs.model.dao.impl.UsersDaoImpl;
import ru.innopolis.isblogs.model.dao.interfaces.UserDao;
import ru.innopolis.isblogs.model.entity.Blog;
import ru.innopolis.isblogs.model.entity.User;
import ru.innopolis.isblogs.utils.ApplicationException;

import java.util.List;

/**
 * Created by Crusher on 01.12.2016.
 */
@Controller
public class ControllerAdmin {
    @Autowired
    private UserDao usersDao;

    @GetMapping(value = "/admin")
    public ModelAndView getLoginForm() {
        List<User> users = null;
        ModelAndView modelAndView = new ModelAndView("/admin");
        try {
            users = usersDao.getAll();
            modelAndView.addObject("users", users);
        } catch (ApplicationException e) {
            modelAndView.addObject("message", e.getMessage());
        }
        return modelAndView;
    }
}
