package ru.innopolis.isblogs.service;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.isblogs.model.dao.interfaces.UserDao;
import ru.innopolis.isblogs.model.entity.User;
import ru.innopolis.isblogs.model.models.UserModel;
import ru.innopolis.isblogs.utils.BaseMapper;

import java.util.List;

/**
 * Created by Crusher on 09.12.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    private MapperFacade mapper = BaseMapper.MAPPER_FACTORY.getMapperFacade();

    @Override
    public String getAddUser(UserModel userModel) {

        if(userModel.getPassword().equals(userModel.getConfPassword())){
            User user = mapper.map(userModel, User.class);
            userDao.addUser(user);
            return "redirect:/login";
        }else return "redirect:/registration";

    }

    @Override
    public List<UserModel> getAllUser() {
        return null;
    }

    @Override
    public UserModel getById(long id) {
        return null;
    }
}
