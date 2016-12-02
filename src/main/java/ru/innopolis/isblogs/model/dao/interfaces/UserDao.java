package ru.innopolis.isblogs.model.dao.interfaces;

import ru.innopolis.isblogs.model.entity.User;
import ru.innopolis.isblogs.utils.ApplicationException;

import java.util.List;

/**
 * Created by Crusher on 30.11.2016.
 */
public interface UserDao extends CommonDao<User> {

    public User checkUser(String login, String password) throws ApplicationException;

    public boolean addUser(String login, String firstName, String lastName, String password, String email) throws ApplicationException;

    public List<User> getAllById(int id);
}
