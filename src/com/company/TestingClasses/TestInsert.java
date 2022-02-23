package com.company.TestingClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory newCon=new ConnectionFactory();
        Connection connection=newCon.createConnection();
        //usa a connectionFactory pra isntanciar a conexão

        Statement stm=connection.createStatement();
        stm.execute("INSERT INTO Produtos(nome,descricao) VALUES ('teclado', 'teclado sem fio')"
        ,Statement.RETURN_GENERATED_KEYS);
        /*cria o statement mas dessa vez como um Insert ja que o objetivo é salvar algo no BD e usa o Statement
        RETURN_GENERATED_KEYS pra que ele devolva qual o id que foi gerado pra esse insert já que nós não definimos
        qual será porque ele é auto incremental e o sgbd cuida disso sozinho.
        */

        ResultSet rst=stm.getGeneratedKeys();
        //pega a chave gerado que nesse caso é um id e printa ele depois
        while (rst.next()){
            int id=rst.getInt(1);
            System.out.println("Created ID:"+id);
        }

        connection.close();
    }

}
