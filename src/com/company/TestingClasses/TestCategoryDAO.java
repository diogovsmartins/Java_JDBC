package com.company.TestingClasses;

import com.company.DAOS.CategoryDAO;
import com.company.SampleObjects.Category;
import com.company.SampleObjects.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestCategoryDAO {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConnectionFactory().createConnection()) {
            CategoryDAO categoryDAO = new CategoryDAO(connection);
            List<Category> categoryList = categoryDAO.listCategoriesWithProducts();

            categoryList.stream().forEach(ct -> {
                        System.out.println("Category: "+ct.getName());
                for (Product product: ct.getProducts()){
                    System.out.println(ct.getName()+"="+product.getName());
                }
            });
        }
    }
}
