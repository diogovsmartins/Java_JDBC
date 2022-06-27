package com.company.TestingClasses;

import com.company.Connection.ConnectionFactory;
import com.company.SampleObjects.Product;

import java.sql.*;

public class TestInsertWithSample {
    public static void main(String[] args) throws SQLException {
        Product product = new Product("Cadeira", "Cadeira de madeira");
        /*uma forma de salvar os dados de um objeto no banco de dados utilizando um modelo que se parece com
         * o que ficara no bd, nesse caso um produto com os mesmos atributos, pode ser util se o objetivo
         * for salvar varias coisas que seguem um padrão como um registro de cliente por exemplo.*/
        try (Connection connectionFactory = new ConnectionFactory().createConnection()) {
            String sql = "INSERT INTO Produtos (nome,descricao) VALUES (?,?)";
            try (PreparedStatement pstm = connectionFactory.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, product.getName());
                pstm.setString(2, product.getDescription());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        product.setId(rst.getInt(1));
                    }
                }
                System.out.println(product);
            }
        }
    }
}
