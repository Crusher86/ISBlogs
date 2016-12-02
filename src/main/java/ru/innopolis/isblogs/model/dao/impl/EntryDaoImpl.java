package ru.innopolis.isblogs.model.dao.impl;

import org.springframework.stereotype.Component;
import ru.innopolis.isblogs.utils.ApplicationException;
import ru.innopolis.isblogs.utils.ConnectionPool;
import ru.innopolis.isblogs.model.dao.interfaces.EntryDao;
import ru.innopolis.isblogs.model.entity.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Crusher on 01.12.2016.
 */
@Component
public class EntryDaoImpl implements EntryDao {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_GETALL = "select * from entries where blog_id=? order by id desc";
    private static final String SQL_DELETE = "delete from entries where id=?";
    private static final String SQL_GET = "select * from entries where id=?";
    private static final String SQL_UPDATE = "update entries set entry=? where id=?";
    private static final String SQL_ADD = "insert into entries (date,entry,blog_id) values (?,?,?)";

    private Entry buildEntry(ResultSet rs) throws SQLException {
        Entry entry = new Entry();
        entry.setId(rs.getInt("id"));
        entry.setDate(rs.getDate("date"));
        entry.setEntry(rs.getString("entry"));
        entry.setBlog_id(rs.getInt("blog_id"));

        return entry;
    }

    @Override
    public List<Entry> getAll() {
        return null;
    }

    @Override
    public Entry getById(int id) throws ApplicationException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_GET);
            statement.setInt(1, id);
            result = statement.executeQuery();

            while(result.next()){
                return buildEntry(result);
            }
        return null;
        } catch (SQLException e) {
            throw new ApplicationException();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                connectionPool.returnConnection(connection);
            }
        }
    }

    @Override
    public void add(Entry model) {

    }

    @Override
    public void update(int id, Map<String, String> requestParams) {

    }

    @Override
    public void delete(int id) throws ApplicationException {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new ApplicationException();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                connectionPool.returnConnection(connection);
            }
        }
    }

    @Override
    public List<Entry> getAllById(int id) throws ApplicationException {
        List<Entry> entries = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;


        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_GETALL);
            statement.setInt(1, id);
            result = statement.executeQuery();

            while(result.next()){
                entries.add(buildEntry(result));
            }
            return entries;
        } catch (SQLException e) {
            throw new ApplicationException();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                connectionPool.returnConnection(connection);
            }
        }
    }

    @Override
    public void updateEntry(int id, String text) throws ApplicationException {

        Connection connection = null;
        PreparedStatement statement = null;


        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, text);
            statement.setInt(2, id);
            statement.execute();

        } catch (SQLException e) {
            throw new ApplicationException();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                connectionPool.returnConnection(connection);
            }
        }
    }

    @Override
    public void addEntry(int blog_id, String text) throws ApplicationException {
        Connection connection = null;
        PreparedStatement statement = null;
        java.util.Date d = new java.util.Date();

        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_ADD);
            statement.setDate(1, new java.sql.Date(d.getTime()));
            statement.setString(2, text);
            statement.setInt(3, blog_id);
            statement.execute();

        } catch (SQLException e) {
            throw new ApplicationException();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                connectionPool.returnConnection(connection);
            }
        }
    }
}
