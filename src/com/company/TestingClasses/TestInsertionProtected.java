package com.company.TestingClasses;

import com.company.Connection.ConnectionFactory;

import java.sql.*;

public class TestInsertionProtected {
    public static void main(String[] args) throws SQLException {
        /*
        Utilizar o preparedStatement quando for receber algum dado que será digitado por alguem mais de uma vez
        pois o BD deixa o statement compilado, apenas esperando os parametros a serem passados. Além disso ao utilizar
        o PreparedStatement o proprio jDBC cuida de tratar o dado e garantir que não é um comando SQL
        ou algum caracter reservado do BD garantindo que a aplicação não quebre por um erro de digitação ou SQL Injection.
        */

        ConnectionFactory newCon = new ConnectionFactory();
        try (Connection connection = newCon.createConnection()) {
            connection.setAutoCommit(false);
            //setAutoCommit pra false pra poder controlar melhor as transações entre a aplicação e o banco de dados

            try (PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO Produtos (nome,descricao) VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                addVariable("TV", "TV 43' ", pst);
                addVariable("Cobertor", "Cobertor verde claro", pst);
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Rollback executed.");
                connection.rollback();
            }
        }
    }

    private static void addVariable(String nome, String descricao, PreparedStatement pst) throws SQLException {
        pst.setString(1, nome);
        pst.setString(2, descricao);

//        if(nome.equals("Cobertor")){
//            throw new RuntimeException("Não foi possivel adicionar o produto");
//        }

        pst.execute();
        try (ResultSet rst = pst.getGeneratedKeys()) {
            while (rst.next()) {
                int id = rst.getInt(1);
                System.out.println("Created ID: " + id);
            }
        }
    }

}
