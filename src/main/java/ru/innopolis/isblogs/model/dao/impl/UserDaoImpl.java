package ru.innopolis.isblogs.model.dao.impl;

import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;
import ru.innopolis.isblogs.model.dao.interfaces.UserDao;
import ru.innopolis.isblogs.model.entity.User;
import ru.innopolis.isblogs.utils.BaseMapper;
import ru.innopolis.isblogs.utils.EntityManagerHolder;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Crusher on 09.12.2016.
 */
@Component
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager = EntityManagerHolder.getEntityManager();
    private MapperFacade mapper = BaseMapper.MAPPER_FACTORY.getMapperFacade();

    @Override
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User getById(long id) {
        return null;
    }
}
