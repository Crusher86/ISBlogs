package ru.innopolis.isblogs.model.dao.interfaces;

import ru.innopolis.isblogs.model.entity.User;

import java.util.List;

/**
 * Created by Crusher on 09.12.2016.
 */
public interface UserDao {

    void addUser(User user);
    List<User> getAllUser();
    User getById(long id);
}
