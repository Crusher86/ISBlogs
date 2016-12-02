package ru.innopolis.isblogs.model.dao.interfaces;

import ru.innopolis.isblogs.model.entity.Blog;
import ru.innopolis.isblogs.utils.ApplicationException;

import java.util.List;

/**
 * Created by Crusher on 30.11.2016.
 */
public interface BlogDao extends CommonDao<Blog> {

    public List<Blog> getAllById(int id) throws ApplicationException;
}
