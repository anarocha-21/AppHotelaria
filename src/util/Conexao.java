package util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class Conexao {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/hotel";
    private String usuario = "dbaHotel";
    private String senha = "dbaHotel123";

    public Connection conectar() {
        Connection condb = null;
        try {
            /*especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)*/
            Class.forName(driver);

            /*inicializar o driver ja carregado por meio do metodo getConnection(IP, port, nome do banco. usuário, senha)*/
            condb = DriverManager.getConnection(url, usuario, senha);
            return condb;

        } catch (SQLException erro) {
            System.out.println("Erro ao conectar ao Banco de Dados: " + erro);
            return null;
        }
    }
}