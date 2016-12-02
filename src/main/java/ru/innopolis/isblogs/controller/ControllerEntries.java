package ru.innopolis.isblogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.isblogs.model.dao.interfaces.EntryDao;
import ru.innopolis.isblogs.model.entity.Entry;
import ru.innopolis.isblogs.utils.ApplicationException;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author Pavel Krohin
 * Класс-контроллер для обработки запросов страницы записей.
 */
@Controller
public class ControllerEntries {

    @Autowired
    private EntryDao entryDao;

    /**
     * Метод формирует страницу с записями дневника пользователя.
     * Получает от клиента id дневника.
     * Отправляет запрос на получения данных.
     * @param diary_id
     * @return Возвращает список записей полученных по id дневника.
     */
    @GetMapping(value = "/diary/{diary_id}")
    public ModelAndView getEntries(@PathVariable int diary_id){

        List<Entry> entries = null;
        ModelAndView modelAndView = new ModelAndView("diary");
        try {
            entries = entryDao.getAllById(diary_id);
            modelAndView.addObject("entries", entries);
        } catch (ApplicationException e) {
            modelAndView.addObject("message", e.getMessage());
        }
        return modelAndView;
    }

    /**
     * Метод обрабатывает запрос на удаление записи из дневника.
     * Принимает id дневника и id записи
     * Формирует запрос на удаление данных из базы данных
     * Если запрос отрабатывает удачно, перенапрявляет на страницу дневника
     * Если возникли проблемы с получением данных из базы данных, возвращает сообщение об ошибке.
     * @param entry_id
     * @param blog_id
     * @return
     */
    @GetMapping(value = "/delete/{blog_id}/{entry_id}")
    public ModelAndView deleteEntries(@PathVariable int entry_id, @PathVariable int blog_id){
        ModelAndView modelAndView = new ModelAndView("redirect:/diary/" + blog_id);
        try {
            entryDao.delete(entry_id);
        } catch (ApplicationException e) {
            modelAndView.addObject("message", e.getMessage());
        }
        return modelAndView;
    }

    /**
     * Метод формирует страницу для редактирования записи
     * Принимает от клиента id записи
     * Формирует запрос в БД для получения записи
     * Если запрос отрабатывает удачно, перенапрявляет на страницу редактирования записи
     * Если возникли проблемы с получением данных из базы данных, возвращает сообщение об ошибке.
     * @param entry_id
     * @return
     */
    @GetMapping(value="/edit_entry/{entry_id}")
    public ModelAndView editEntry(@PathVariable int entry_id){
        ModelAndView modelAndView = new ModelAndView("/edit_entry");

        try {
            Entry entry = entryDao.getById(entry_id);
            modelAndView.addObject("entry", entry);
        } catch (ApplicationException e) {
            modelAndView.addObject("message", e.getMessage());
        }
        return modelAndView;
    }

    /**
     * Метод формирует страницу для добавления записи
     * @param blog_id
     * @return
     */
    @GetMapping(value="/new_entry/{blog_id}")
    public ModelAndView newEntry(@PathVariable int blog_id){
        ModelAndView modelAndView = new ModelAndView("/new_entry");
        modelAndView.addObject("title", "New entry form");
        return modelAndView;
    }

    /**
     * Метод обрабатывает запрос для добавления записи
     * Принимает от клиента id дневника и текст записи
     * Формирует запрос в БД для добавления записи
     * Если запрос отрабатывает удачно, перенапрявляет на страницу дневника
     * Если возникли проблемы с получением данных из базы данных, возвращает сообщение об ошибке.
     * @param text
     * @param blog_id
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping(value="/new_entry/{blog_id}")
    public ModelAndView createEntry(@RequestParam ("entry_out") String text, @PathVariable int blog_id) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("redirect:/diary/" + blog_id);
        try {
            entryDao.addEntry(blog_id, new String(text.getBytes("ISO-8859-1"), "UTF-8"));
            modelAndView.addObject("blog_id", blog_id);
        } catch (ApplicationException e) {
            modelAndView.addObject("message", e.getMessage());
        }
        return modelAndView;
    }

    /**
     * Метод обрабатывает запрос редактирования записи
     * Принимает от клиента id записи и текст записи
     * Формирует запрос в БД для обновления записи
     * Если запрос отрабатывает удачно, перенапрявляет на страницу дневника
     * Если возникли проблемы с получением данных из базы данных, возвращает сообщение об ошибке.
     * @param text
     * @param entry_id
     * @param model
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping(value="/edit_entry/{entry_id}")
    public String saveEntry(@RequestParam ("entry_out") String text, @PathVariable int entry_id, Model model) throws UnsupportedEncodingException {
        try {
            Entry entry = entryDao.getById(entry_id);
            entryDao.updateEntry(entry_id, new String(text.getBytes("ISO-8859-1"), "UTF-8"));
            return "redirect:/diary/" + entry.getBlog_id();
        } catch (ApplicationException e) {
            model.addAttribute("message", e.getMessage());
            return "/edit_entry/" + entry_id;
        }


    }
}
