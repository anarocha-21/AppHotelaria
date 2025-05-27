package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class Conexao {

    private String driver;
                                //jdbc:mysql://localhost:3306/dbHotel
    private String url;
    private String usuario;
    private String senha;

    /*inicializar um construtor, de modo que quando essa classe Conexão.java instanciar um
    objeto, o construtor será executado e a classe Conexao.java inicializada */

    public Conexao() {
        carregarConfiguracoes();
    }

    //metodo com parametros de configuração das variaveis de ambiente
    private void carregarConfiguracoes() {
        Properties props = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream
                ("config.properties")) {
            props.load(inputPropsConfig);
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            usuario = props.getProperty("usuario");
            senha = props.getProperty("senha");
        }
        catch (IOException erro) {
            System.out.println("Erro ao carregar configurações: " + erro.getMessage());
        }
    }

    public Connection conectar() {
        Connection condb = null;
        try {
            /*especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)*/
            Class.forName(driver);

            /*inicializar o driver ja carregado por meio do metodo getConnection(IP, port, nome do banco. usuário, senha)*/
            condb = DriverManager.getConnection(url, usuario, senha);
            return condb;

        } catch (SQLException | ClassNotFoundException erro) {
            System.out.println("Erro ao conectar ao Banco de Dados: " + erro);
            return null;
        }
    }
}