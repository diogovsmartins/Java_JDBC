package com.company.TestingClasses;

import java.sql.*;

public class TestSelect {
    public static void main(String[] args) throws SQLException {
        String urlCon = "jdbc:mysql://localhost/LojaVirtual?useTimezone=true&serverTimezone=UTC";

        Connection connection = DriverManager
                .getConnection(urlCon, "root", "1234");

        //pega a conexão, nesse caso foi colado mesmo mas provavelmente com um metodo também deve dar certo


        PreparedStatement stm = connection.prepareStatement("SELECT id, nome, descricao FROM Produtos");
        stm.execute();
        ResultSet rst = stm.getResultSet();

        /*Usa a interface Statement do java.sql pra utilizar a conexão existente e criar um statement que será executado
        no BD depois disso usa o metodo execute passando o statement desejado, nesse caso um select e para pegar os dados
        utiliza a interface resultSet também do java.sql e usa o statement que foi executado no bd com o metodo getResultSet
        depois disso só decidir a forma que será mostrado os dados.
        */

        while (rst.next()) {
            Integer id = rst.getInt("id");
            System.out.println(id);
            String nome = rst.getString("nome");
            System.out.println(nome);
            String descricao = rst.getString("descricao");
            System.out.println(descricao);
        }
        /*nesse caso será printado no console então se utiliza o resultSet com o metodo específico
        pro tipo de dado que será mostrado.
        */
        connection.close();
    }
}
