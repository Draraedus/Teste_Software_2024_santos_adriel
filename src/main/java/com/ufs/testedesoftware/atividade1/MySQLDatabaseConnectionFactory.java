package com.ufs.testedesoftware.atividade1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabaseConnectionFactory implements DatabaseConnectionFactory {

    @Override public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://myhost:1111/database", "username", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}