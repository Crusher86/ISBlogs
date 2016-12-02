package ru.innopolis.isblogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.isblogs.model.dao.impl.UsersDaoImpl;
import ru.innopolis.isblogs.model.dao.interfaces.UserDao;
import ru.innopolis.isblogs.model.entity.User;
import ru.innopolis.isblogs.utils.ApplicationException;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Pavel Krohin
 * Класс-контроллер для обработки запросов редактирования профиля.
 */
@Controller
public class ControllerEditProfile {
    private static final String PARAM_FNAME = "firstName";
    private static final String PARAM_LNAME= "lastName";
    private static final String PARAM_PROF= "profession";
    private static final String PARAM_DBIRTH= "dateBirth";
    private static final String PARAM_GENDER= "gender";
    private static final String PARAM_ADDR= "address";
    private static final String PARAM_EMAIL= "email";
    private final String PAGE_EDIT = "/edit";
    @Autowired
    private UserDao users;


    /**
     * Метод для формирования страницы редактирования профиля
     * Получает id пользователя из сессии
     * Формирует запрос на получение данных пользователя в БД
     * Если запрос отрабатывает удачно, отправляет данные пользователя на страницу
     * Если возникли проблемы с получением данных из базы данных, возвращает сообщение об ошибке.
     * @param session
     * @param model
     * @return
     */
    @GetMapping(value = PAGE_EDIT)
    public String getEditForm(HttpSession session, Model model) {
        User user = null;
        try {
            user = users.getById(Integer.parseInt(session.getAttribute("id").toString()));
            model.addAttribute("user", user);
            model.addAttribute("title", "Edit form");
            return PAGE_EDIT;
        } catch (ApplicationException e) {
            model.addAttribute("message", e.getMessage());
            return PAGE_EDIT;
        }
    }

    /**
     * Метод обрабатывает запрос редактирования профиля
     * Принимает из сесии id пользователя и данные из полей
     * Формирует запрос в БД для обновления профиля
     * Если запрос отрабатывает удачно, перенапрявляет на страницу профиля
     * Если возникли проблемы с получением данных из базы данных, возвращает сообщение об ошибке.
     * @param session
     * @param requestParams
     * @param model
     * @return
     */
    @PostMapping(value = PAGE_EDIT)
    public String updateProfile(HttpSession session, @RequestParam Map<String, String> requestParams, Model model){

        try {
            users.update(Integer.parseInt(session.getAttribute("id").toString()), requestParams);
            User user = users.getById(Integer.parseInt(session.getAttribute("id").toString()));
            model.addAttribute("user", user);

        } catch (ApplicationException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "/profile";
    }
}
