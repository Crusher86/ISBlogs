package ru.innopolis.isblogs.model.dao.impl;


import org.springframework.stereotype.Component;
import ru.innopolis.isblogs.utils.ApplicationException;
import ru.innopolis.isblogs.utils.ConnectionPool;
import ru.innopolis.isblogs.model.dao.interfaces.BlogDao;
import ru.innopolis.isblogs.model.entity.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Crusher on 25.11.2016.
 */
@Component
public class BlogsDaoImpl implements BlogDao{

    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_GETALL = "select * from blogs where user_id = ?";

    private Blog buildBlog(ResultSet rs) throws SQLException {
        Blog blog = new Blog();
        blog.setId(rs.getInt("id"));
        blog.setTitle(rs.getString("title"));
        blog.setUser_id(rs.getInt("user_id"));

        return blog;
    }

    @Override
    public List<Blog> getAll() {
        return null;
    }

    @Override
    public Blog getById(int id) {
        return null;
    }

    @Override
    public void add(Blog model) {

    }

    @Override
    public void update(int id, Map<String, String> requestParams) {

    }

    @Override
    public void delete(int id) throws ApplicationException {

    }

    @Override
    public List<Blog> getAllById(int id) throws ApplicationException {
        List<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_GETALL);
            statement.setInt(1, id);
            result = statement.executeQuery();

            while (result.next()) {

                blogs.add(buildBlog(result));

            } return blogs;
        } catch (SQLException e) {
            throw new ApplicationException();
        } finally {
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
