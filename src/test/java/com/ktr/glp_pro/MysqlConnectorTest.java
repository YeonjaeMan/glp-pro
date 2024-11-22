package com.ktr.glp_pro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

public class MysqlConnectorTest {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            fail("MySQL JDBC Driver not found.");
        }
    }

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.user}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Test
    public void testConnection() {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful: " + con);
        } catch (SQLException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
