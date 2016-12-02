package ru.innopolis.isblogs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by Crusher on 22.11.2016.
 */
public class ConnectionPool {

    private static ConnectionPool instance;
    private final String CONNECTIONURL = "jdbc:postgresql://localhost:5432/BlogsNew";
    private final String DRIVER = "org.postgresql.Driver";
    private final String ADMIN_LOGIN = "postgres";
    private final String ADMIN_PASSWORD = "12345";
    private static int count = 0;
    final int MAX_POOL_SIZE = 50;

    Vector connectionPool = new Vector();

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnectionFromPool() {

        Connection connection = null;

        if (count < MAX_POOL_SIZE) {
            connection = createConnection();
            return connection;
        } else {
            if (connectionPool.size() == MAX_POOL_SIZE){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            connection = (Connection) connectionPool.firstElement();
            connectionPool.removeElementAt(0);
            return connection;
        }
    }

    public synchronized void returnConnection(Connection connection) {

        connectionPool.addElement(connection);
        notifyAll();

    }

    private Connection createConnection() {

        Connection connection = null;
        count++;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECTIONURL, ADMIN_LOGIN, ADMIN_PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
