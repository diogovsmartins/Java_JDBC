package com.company.TestingClasses;

import com.company.Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionPool {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        //cria a connection factory com a pool aberta com 15 conexões como setado lá na connectionFactory
        for (int i = 0; i < 20; i++) {
            Connection connection = connectionFactory.createConnection();
            System.out.println("Criando conexão numero: " + i);

            /*pede a conexão 20 vezes pra ver como a factory se comporta, nesse caso como o número de
            conexões solicitadas é maior do que o número de conexões abertas, a pool entrega as 15 abertas
            e enfileira as outras 5 para que assim que uma das conexões em uso seja liberada a primeira da fila
            possa utilizar a conexão que estará na pool novamente.*/
        }
    }
}
