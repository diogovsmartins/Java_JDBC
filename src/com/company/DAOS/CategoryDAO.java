package com.company.DAOS;

import com.company.SampleObjects.Category;
import com.company.SampleObjects.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Category> listCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT ID, NOME FROM Categorias";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();
            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Category category = new Category(rst.getInt(1), rst.getString(2));

                    categories.add(category);
                }
            }
        }
        return categories;
    }

    public List<Category> listCategoriesWithProducts() throws SQLException {
        List<Category> categories = new ArrayList<>();
        Category last = null;

        String sql = "SELECT  C.id, C.nome, P.id, P.nome, P.descricao FROM Categorias C INNER JOIN Produtos P " +
                "ON P.categoria_id=C.id";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    if (last == null || !last.getName().equals(rst.getString(2))) {
                        Category category = new Category(rst.getInt(1), rst.getString(2));
                        last = category;
                        categories.add(category);
                    }
                    Product product = new Product(rst.getInt(3), rst.getString(4), rst.getString(5));
                    last.add(product);
                }
            }
        }
        return categories;
    }

}
