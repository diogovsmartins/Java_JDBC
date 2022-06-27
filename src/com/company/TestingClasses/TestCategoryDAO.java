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

            categoryList.stream().forEach(category -> {
                System.out.println("\nCategory: " + category.getName());
                category.getProducts().forEach(System.out::println);
            });
        }
    }
}
