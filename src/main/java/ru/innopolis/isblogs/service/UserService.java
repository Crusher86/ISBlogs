package ru.innopolis.isblogs.service;

import ru.innopolis.isblogs.model.models.UserModel;

import java.util.List;

/**
 * Created by Crusher on 09.12.2016.
 */
public interface UserService {

    String getAddUser(UserModel userModel);

    List<UserModel> getAllUser();

    UserModel getById(long id);
}
