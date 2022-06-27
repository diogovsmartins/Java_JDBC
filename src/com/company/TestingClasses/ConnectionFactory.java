package com.company.TestingClasses;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    /*
    padrão de projeto connectionFactory, sempre que for preciso instanciar uma conexão é usado esse metodo chamado
    createConnection, essa classe será como o nome já diz uma fabrica de conexões.
    também é particularmente útil porque deixara as partes que usam a conexão desacopladas da classe que cuida da conexão
    propriamente dita, fazendo com que seja mais fácil de refatorar e mudar coisas como por exemplo o usuário ou a senha
    ou conectar em outros bancos de dados.
    */
    private final String urlCon = "jdbc:mysql://localhost/LojaVirtual?useTimezone=true&serverTimezone=UTC";
    private DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(urlCon);
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("1234");
        comboPooledDataSource.setMaxPoolSize(15);
        this.dataSource = comboPooledDataSource;
    }

    public Connection createConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

}
