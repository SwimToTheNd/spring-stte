package com.stte.spring.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * create by BloodFly at 2020/7/4
 */
public class JdbcUtil {

    public static final String url = "jdbc:mysql://localhost:3306/mysql_test_db?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    public static final String userName = "root";
    public static final String passwd = "123456";
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    public static Connection getConnection(boolean commit) {
        Connection connection = connectionThreadLocal.get();
        if (connection == null) {
            try {
                connection = buildConnection();
                connection.setAutoCommit(commit);
            } catch (Exception e) {
                System.err.println("%%% Error create connection! %%%");
                e.printStackTrace();
            }
            connectionThreadLocal.set(connection);
        }
        return connection;
    }

    private static Connection buildConnection() throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, passwd);
        return connection;
    }

}
