package ru.innopolis.isblogs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;


@Controller
public class HomeController {



    @GetMapping(value = "/home")
    public ModelAndView getBlogs(HttpSession session){

//        List<Blog> blogs = null;
        ModelAndView modelAndView = new ModelAndView("home");
//        try {
//            blogs = blogsDao.getAllById(Integer.parseInt(session.getAttribute("id").toString()));
//            modelAndView.addObject("blogs", blogs);
//        } catch (ApplicationException e) {
//            modelAndView.addObject("message", e.getMessage());
//        }
        return modelAndView;
    }
}
