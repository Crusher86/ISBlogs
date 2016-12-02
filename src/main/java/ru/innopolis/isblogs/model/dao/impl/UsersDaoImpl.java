package ru.innopolis.isblogs.model.dao.impl;

import org.springframework.stereotype.Component;
import ru.innopolis.isblogs.model.dao.interfaces.UserDao;
import ru.innopolis.isblogs.model.entity.User;
import ru.innopolis.isblogs.utils.ApplicationException;
import ru.innopolis.isblogs.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Crusher on 22.11.2016.
 */
@Component
public class UsersDaoImpl implements UserDao{

    private static final String SQL_CHECK = "select * from users where login = ?";
    private static final String SQL_GETALL = "select * from users";
    private static final String SQL_GET = "select * from users where id = ?";
    private static final String SQL_UPDATE = "update users set first_name=?,last_name=?,profession=?,date_birth=?,gender=?,address=?,email=?,phone_number=? where id=?";
    private static final String SQL_ADD = "insert into users (login,password,first_name,last_name,email) values (?,?,?,?,?)";
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private String userPassword = null;

    private User buildUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone_number"));
        user.setProfession(rs.getString("profession"));
        user.setDate_birth(rs.getDate("date_birth"));
        user.setGender(rs.getInt("gender"));
        user.setAddress(rs.getString("address"));

        return user;
    }

    public User checkUser(String login, String password) throws ApplicationException{

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_CHECK);
            statement.setString(1, login);
            result = statement.executeQuery();

            while (result.next()) {
                userPassword = result.getString("password");

                if (password.equals(userPassword)) {
                        return buildUser(result);
                } else return null;
            } return null;
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

    @Override
    public boolean addUser(String login, String firstName, String lastName, String password, String email) throws ApplicationException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_ADD);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, email);
            return statement.execute();


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
    public List<User> getAllById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() throws ApplicationException {

        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;


        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_GETALL);
            result = statement.executeQuery();

            while (result.next()) {
                users.add(buildUser(result));
            }
            return users;
        } catch (SQLException e) {
            throw new ApplicationException();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    @Override
    public User getById(int id) throws ApplicationException{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_GET);
            statement.setInt(1, id);
            result = statement.executeQuery();

            while (result.next()) {
                return buildUser(result);
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
    public void add(User model) {

    }

    @Override
    public void update(int id, Map<String,String> requestParams) throws ApplicationException {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionPool.getConnectionFromPool();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, requestParams.get("firstName"));
            statement.setString(2, requestParams.get("lastName"));
            statement.setString(3, requestParams.get("profession"));
            statement.setDate(4, Date.valueOf(requestParams.get("dateBirth")));
            statement.setInt(5, Integer.parseInt(requestParams.get("gender")));
            statement.setString(6, requestParams.get("address"));
            statement.setString(7, requestParams.get("email"));
            statement.setString(8, requestParams.get("phone"));
            statement.setInt(9, id);
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
    public void delete(int id) throws ApplicationException {

    }
}
