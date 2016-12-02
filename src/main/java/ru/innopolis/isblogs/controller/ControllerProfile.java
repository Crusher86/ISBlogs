package ru.innopolis.isblogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.isblogs.model.dao.interfaces.UserDao;
import ru.innopolis.isblogs.model.entity.User;
import ru.innopolis.isblogs.utils.ApplicationException;

import javax.servlet.http.HttpSession;

/**
 * @author Pavel Krohin
 * Класс-контроллер для обработки запросов страницы профиля.
 */
@Controller
public class ControllerProfile {
    private final String PAGE_PROFILE = "/profile";
    @Autowired
    private UserDao users;

    /**
     * Метод формирует страницу профиля.
     * Принимает из сессии id пользователя, отправляет запрос на данные из базы данных
     * Возвращает данные пользователя на страницу профиля
     * Если возникли проблемы с получением данных из базы данных, возвращает сообщение об ошибке.
     * @param session
     * @param model
     * @return
     */
    @GetMapping(value = PAGE_PROFILE)
    public String getProfile(HttpSession session, Model model){

        User user = null;
        try {
            user = users.getById(Integer.parseInt(session.getAttribute("id").toString()));
            model.addAttribute("user", user);
            return PAGE_PROFILE;
        } catch (ApplicationException e) {
            model.addAttribute("message", e.getMessage());
            return "/home";
        }
    }
}
