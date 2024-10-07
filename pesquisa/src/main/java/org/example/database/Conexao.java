package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String url;
    private String usuario;
    private String senha;

    public Conexao() {}

    public Conexao(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection getConexao() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return connection;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
