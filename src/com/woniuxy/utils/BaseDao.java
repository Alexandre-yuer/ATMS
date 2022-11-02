package com.woniuxy.utils;

import java.sql.*;

/**
 * JDBC工具类
 */
public class BaseDao {
    // 数据库的连接url
    private String url = "jdbc:mysql://127.0.0.1:3306/test_jdbc?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    // 用户名
    private String user = "root";
    // 密码
    private String password = "root";
    // 驱动串
    private String className = "com.mysql.cj.jdbc.Driver";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    // 1.建立连接获取connection对象
    public Connection getConnection() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 2.获取PreparedStatment对象
    public PreparedStatement getPreparedStatement(String sql) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    // 3.执行sql-- excuteUpdate()
    public int excuteUpdate(String sql) {
        int count = 0;
        try {
            count = getPreparedStatement(sql).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return count;
    }

    // 4.执行sql-- excuteQuery()
    public ResultSet excuteQuery(String sql) {
        try {
            this.resultSet = getPreparedStatement(sql).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.resultSet;
    }

    //5.释放所有资源
    public void closeAll() {
        try {
            if (resultSet != null) {
                resultSet.close();
                this.resultSet = null;
            }
            if (preparedStatement != null) {
                preparedStatement.close();
                this.preparedStatement = null;
            }
            if (connection != null) {
                connection.close();
                this.connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
