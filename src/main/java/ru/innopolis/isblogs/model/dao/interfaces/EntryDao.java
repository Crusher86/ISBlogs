package ru.innopolis.isblogs.model.dao.interfaces;

import ru.innopolis.isblogs.model.entity.Entry;
import ru.innopolis.isblogs.utils.ApplicationException;

import java.util.List;

/**
 * Created by Crusher on 01.12.2016.
 */
public interface EntryDao extends CommonDao<Entry> {

    public List<Entry> getAllById(int id) throws ApplicationException;

    public void updateEntry(int id, String text) throws ApplicationException;

    public void addEntry(int blog_id, String text) throws ApplicationException;

}
