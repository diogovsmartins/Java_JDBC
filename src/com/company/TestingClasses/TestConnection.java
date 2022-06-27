package com.company.TestingClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        /*
        Instancia uma conexão usando as interfaces do java.sql e passa no parametro uma url que contem ao menos
        os seguintes dados:
        "jdbc:bancoDeDado://endereçoDoSv/NomeDoBD;
        o ?useTimezone=true&serverTimezone=UTC; é pra definir qual a timezone que será utilizada pelo banco de dados
        prevenindo erros futuros que poderiam aparecer com a diferença de fuso horário por exemplo.

        É necessário ter Um driver pro banco de dados, que é uma biblioteca (JAR) que precisa ser importada
        pro build path do projeto.

        */
        String urlCon = "jdbc:mysql://localhost/LojaVirtual?useTimezone=true&serverTimezone=UTC";

        Connection connection = DriverManager
                .getConnection(urlCon, "root", "1234");

        System.out.println("Closing connection.");
        connection.close();
    }
}
