//Dentro do package util, criar a classe TesteConexao.java, segue código abaixo:
package util;

/*Classe criada apenas para testar a requisição de conexão ao banco
de dados, de modo a verificar se o SGBD MySQl está rodando na porta 3306,
se os parâmetros como endereço IP do servidor, nome de usuário,
senha e nome do banco de dados estão corretos, utilizando-se
o driver JDBC para MySQL*/

import dao.*;

import java.sql.Connection;


public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelcida com sucesso!");
            try {

                UsuariosDAO usuariosDAO = new UsuariosDAO();
                usuariosDAO.inserirUsuario();
                System.out.println("Usuario inserido com sucesso!");

                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.inserirCliente();
                System.out.println("Cliente inserido com sucesso!");

                QuartosDAO quartosDAO = new QuartosDAO();
                quartosDAO.inserirQuarto();
                System.out.println("Quarto inserido com sucesso!");

                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.inserirAdicionais();
                System.out.println("Adicionais inserido com sucesso!");

                RegrasDAO regrasDAO = new RegrasDAO();
                regrasDAO.inserirRegras();
                System.out.println("Cargo inserido com sucesso!");

                condb.close();
                    System.out.println("Conexão encerrada!");
                } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}