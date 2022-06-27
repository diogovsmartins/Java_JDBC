package com.company.TestingClasses;

import com.company.Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDelete {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory newCon = new ConnectionFactory();
        Connection connection = newCon.createConnection();

        PreparedStatement stm = connection.prepareStatement("DELETE FROM Produtos where ID > ?");
        stm.setInt(1, 2);
        stm.execute();

        Integer updatedLines = stm.getUpdateCount();
        /* Mesmos passos anteriores mas muda o statement e o getUpdateCount que retorna o numero de colunas
         * que foram afetadas pela query no BD.*/
        System.out.println("Lines updated: " + updatedLines);

        connection.close();
    }
}
