package com.company.TestingClasses;

import com.company.DAOS.ProductDAO;
import com.company.SampleObjects.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestsWithDAO {
    public static void main(String[] args) throws SQLException {
        /*Exemplo de implementação do DAO, bem mais legivel, facil de entender e bem menos código repetido*/

        Product product =new Product("Mesa", "Mesa 4 lugares");

        try(Connection connection=new ConnectionFactory().createConnection()){
            ProductDAO productDAO=new ProductDAO(connection);
            productDAO.save(product);

            List<Product> pl=productDAO.list();
            pl.stream().forEach(lp -> System.out.println(lp));
        }
    }
}
