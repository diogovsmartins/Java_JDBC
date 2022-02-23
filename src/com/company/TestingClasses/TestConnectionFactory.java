package com.company.TestingClasses;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionFactory {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory newCon= new ConnectionFactory();
        Connection connection=newCon.createConnection();

        connection.close();

    }
}
