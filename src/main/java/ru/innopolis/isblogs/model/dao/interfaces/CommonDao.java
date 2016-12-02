package ru.innopolis.isblogs.model.dao.interfaces;

import ru.innopolis.isblogs.model.entity.Model;
import ru.innopolis.isblogs.utils.ApplicationException;

import java.util.List;
import java.util.Map;

/**
 * Created by Crusher on 30.11.2016.
 */
public interface CommonDao<T extends Model>{

    public List<T> getAll() throws ApplicationException;

    public T getById(int id) throws ApplicationException;

    public void add(T model);

    public void update(int id, Map<String, String> requestParams) throws ApplicationException;

    public void delete(int id) throws ApplicationException;
}
