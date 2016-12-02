package ru.innopolis.isblogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.isblogs.model.dao.interfaces.UserDao;
import ru.innopolis.isblogs.utils.ApplicationException;
import ru.innopolis.isblogs.utils.CryptUtil;

import javax.servlet.http.HttpServlet;

/**
 * @author  Pavel Krohin
 * Класс-контроллер, отвечает за запросы на регистрацию пользователя. Принимает запросы со стороны клиента, перенаправляет
 * на обработку и возвращает ответ от сервера.
 */
@Controller
public class ControllerUserRegistration extends HttpServlet {

    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_FNAME = "first_name";
    private static final String PARAM_LNAME = "last_name";
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_CONF_PASSWORD = "conf_password";
    private static final String PAGE_REG = "/registration";
    private static final String PAGE_OK = "/login";
    private CryptUtil cryptUtil = new CryptUtil();

    @Autowired
    private UserDao users;

    /**
     * Метод формирования страницы регистрации
     * @return ModelAndView - отправляет клиенту заголовок страницы
     */
    @GetMapping(value = PAGE_REG)
    public ModelAndView getRegForm() {
        ModelAndView model = new ModelAndView(PAGE_REG);
        model.addObject("title", "Registration form");
        return model;
    }

    /**
     * Метод регистрации пользователя
     * Принимает от клиента данные для регистрации
     * Отправляет данные для добавления в базу данных
     * Если проблем с добавлением не было, перенапрвляет на страницу авторизации с сообщением
     * об удачной регистрации и необходимостью авторизоваться в системе.
     * Если возникли проблемы с базой данных, возвращает сообщение о проблеме
     * @param login
     * @param firstName
     * @param lastName
     * @param password
     * @param conf_password
     * @param email
     * @param model
     * @return
     */
    @PostMapping(value = PAGE_REG)
    public String registration(@RequestParam (PARAM_LOGIN) String login,
                                @RequestParam (PARAM_FNAME) String firstName,
                                @RequestParam (PARAM_LNAME) String lastName,
                                @RequestParam (PARAM_PASSWORD) String password,
                                @RequestParam (PARAM_CONF_PASSWORD) String conf_password,
                                @RequestParam (PARAM_EMAIL) String email,
                                Model model){
        if (password.equals(conf_password)){

            try {
                if (!users.addUser(login, firstName, lastName, cryptUtil.cript(password), email)){
                    model.addAttribute("message1", "Registration completed successfully. Login please.");
                    return PAGE_OK;
                }else{
                    model.addAttribute("message", "Login already exists");
                    return PAGE_REG;
                }
            } catch (ApplicationException e) {
                model.addAttribute("message", e.getMessage());
                return PAGE_REG;
            }


        }else{
            model.addAttribute("message", "passwords do not match");
            return PAGE_REG;
        }
    }
}
