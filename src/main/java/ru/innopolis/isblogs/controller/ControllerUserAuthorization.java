package ru.innopolis.isblogs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.isblogs.model.dao.interfaces.UserDao;
import ru.innopolis.isblogs.model.entity.User;
import ru.innopolis.isblogs.utils.ApplicationException;
import ru.innopolis.isblogs.utils.CryptUtil;

/**
 * @author Pavel Krohin
 *
 * Класс-контроллер, отвечает за запросы на авторизацию пользователя. Принимает запросы со стороны клиента, перенаправляет
 * на обработку и возвращает ответ от сервера.
 */
@Controller
@SessionAttributes("id")
public class ControllerUserAuthorization{
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String PAGE_OK = "redirect:/home";
    private static final String PAGE_LOGIN = "/login";
    private CryptUtil cryptUtil = new CryptUtil();

    @Autowired
    private UserDao users;

    /**
     * Метод получения главной страницы
     * @return ModelAndView - перенаправляет на страницу авторизации
     */
    @GetMapping(value = "/")
    public ModelAndView getMainPage() {
        return getLoginForm();
    }

    /**
     * Метод формирования страницы авторизации
     * @return ModelAndView - отправляет клиенту заголовок страницы
     */
    @GetMapping(value = PAGE_LOGIN)
    public ModelAndView getLoginForm() {
        ModelAndView model = new ModelAndView(PARAM_LOGIN);
        model.addObject("title", "Login form");
        return model;
    }

    /**
     * Метод авторизации пользователя.
     * Принимает от клиента логин и пароль.
     * Отправляет данные на проверку
     * Если данные есть в базе данных, перенаправляет на страницу с дневниками пользователя
     * и сохраняет id пользователя в сессии
     * Если данные ошибочны или их нет в базе данных,
     * отправляет сообщение на страницу авторизации "login or password incorrect!"
     * Если произошел сбой в подключении к базе данных или получении ответа,
     * отправляет сообщение на страницу авторизации "Could not connect to database!"
     * @param login
     * @param password
     * @param model
     * @return - URL страницы, на которую перенаправляет
     */
    @PostMapping(value = PAGE_LOGIN)
    public String authorization(@RequestParam (PARAM_LOGIN) String login,
                                @RequestParam (PARAM_PASSWORD) String password, Model model){
        if (login != null && password != null){

            User user = null;
            try {
                user = users.checkUser(login, cryptUtil.cript(password));
                if (user != null){
                    model.addAttribute("id", user.getId());
                    return PAGE_OK;
                }else {
                    model.addAttribute("message", "login or password incorrect!");
                    return PAGE_LOGIN;
                }
            } catch (ApplicationException e) {
                model.addAttribute("message", e.getMessage());
                return PAGE_LOGIN;
            }


        }
        return PAGE_LOGIN;
    }

    /**
     * Метод для выхода из системы
     * Завершается сессия, закрывается доступ к компонентам(страницам) системы.
     * @param status
     * @return - URL страницы авторизации
     */
    @GetMapping(value = "/logout")
    public String logOut(SessionStatus status){
        status.setComplete();
        return PAGE_LOGIN;
    }
}
