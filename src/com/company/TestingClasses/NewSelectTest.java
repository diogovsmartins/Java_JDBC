package com.company.TestingClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewSelectTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        /*com o pool de conexões implementado agora é só criar o objeto da conection e utilizar as conexões
        que já estão abertas dentro da pool para realizar as operações que forem necessárias, então só utilizar
        a interface Connection do JDBC pegar a conexão dentro da pool com o metodo createConnection e criar
        os statments que serão executados no BD.*/

        try (Connection connection = connectionFactory.createConnection()) {

            PreparedStatement pst = connection.prepareStatement("SELECT id, nome, descricao FROM Produtos ");
            pst.execute();
            ResultSet rst = pst.getResultSet();

            while (rst.next()) {
                int id = rst.getInt("id");
                String nome = rst.getString("nome");
                String descricao = rst.getString("descricao");
                System.out.println("ID: " + id + " Nome: " + nome + " Descricao: " + descricao);
            }
        }
    }
}
