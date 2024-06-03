package com.finance.financerobot;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class MysqlTest {
    
    public static void testDatabaseConnection() {
        String url = "jdbc:mysql://localhost:3306/statadata?characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "12345";

        try {
            // 获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            // 创建语句执行者
            Statement statement = connection.createStatement();

            // 执行查询
            ResultSet resultSet = statement.executeQuery("SELECT VERSION()");

            // 处理结果
            if (resultSet.next()) {
                System.out.println("Database Version: " + resultSet.getString(1));
            }

            // 关闭连接
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testDatabaseConnection();
    }
}


