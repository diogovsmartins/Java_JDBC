package com.company.DAOS;

import com.company.SampleObjects.Product;
import com.mchange.v1.lang.BooleanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    /*DAO (Data Access Object) é um project pattern de uma classe que tem o trabalho de acessar os dados de um objeto e salva-lo
     * no banco de dados, é bem util para reduzir a reescrita de código e também porque desacopla um pouco
     * mais o código e fica facil refatorar caso seja preciso mudar ou implementar algo.*/

    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Product product) throws SQLException {
        /*Aqui temos um guard clause ou bouncer pattern para garantir que caso seja passado um objeto nulo
        ou vazio, o metodo de salvar não vai continuar a executar a query já que pra esse fluxo um objeto
        não nulo/vazio é essencial.*/

        if(product==null || product.getName().isBlank() || product.getDescription().isEmpty()){
            return;
        }

        String sql = "INSERT INTO Produtos (nome,descricao) VALUES (?,?)";

        try (PreparedStatement pstm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, product.getName());
            pstm.setString(2, product.getDescription());
            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    product.setId(rst.getInt(1));
                }
            }
        }

    }

    public List<Product> list() throws SQLException {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT ID, NOME, DESCRICAO FROM Produtos";

        try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
            pstm.execute();
            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Product product = new Product
                            (rst.getInt(1), rst.getString(2), rst.getString(3));
                    products.add(product);
                }
            }
            return products;
        }
    }
}
