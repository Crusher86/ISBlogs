package ru.innopolis.isblogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.isblogs.model.dao.impl.BlogsDaoImpl;
import ru.innopolis.isblogs.model.dao.interfaces.BlogDao;
import ru.innopolis.isblogs.model.entity.Blog;
import ru.innopolis.isblogs.utils.ApplicationException;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Pavel Krohin
 * Класс-контроллер для обработки запросов страницы дневников.
 */
@Controller
public class ControllerHomePage {
    @Autowired
    private BlogDao blogsDao;

    /**
     * Метод формирует страницу со списком дневников пользователя.
     * Берет из сессии id пользователя.
     * Отправляет запрос на получение данных о дневниках пользователя.
     * Возвращает список дневников.
     * Если возникли проблемы с получением данных из базы данных, возвращает сообщение об ошибке.
     * @param session
     * @return
     */
    @GetMapping(value = "/home")
    public ModelAndView getBlogs(HttpSession session){

        List<Blog> blogs = null;
        ModelAndView modelAndView = new ModelAndView("home");
        try {
            blogs = blogsDao.getAllById(Integer.parseInt(session.getAttribute("id").toString()));
            modelAndView.addObject("blogs", blogs);
        } catch (ApplicationException e) {
            modelAndView.addObject("message", e.getMessage());
        }
        return modelAndView;
    }
}
