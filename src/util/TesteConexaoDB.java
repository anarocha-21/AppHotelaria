//Dentro do package util, criar a classe TesteConexao.java, segue código abaixo:
package util;

/*Classe criada apenas para testar a requisição de conexão ao banco
de dados, de modo a verificar se o SGBD MySQl está rodando na porta 3306,
se os parâmetros como endereço IP do servidor, nome de usuário,
senha e nome do banco de dados estão corretos, utilizando-se
o driver JDBC para MySQL*/

import controller.UsuarioController;
import dao.*;
import model.Usuario;

import java.sql.Connection;


public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        //UsuariosDAO usuariosDAO = new UsuariosDAO();
        UsuarioController usuarioController = new UsuarioController();

        if (condb != null) {
            System.out.println("Conexão estabelcida com sucesso!");
            try {

                /*UsuariosDAO usuariosDAO = new UsuariosDAO();
                usuariosDAO.inserirUsuario();
                System.out.println("Usuário inserido com sucesso!");
                UsuariosDAO altUsuDAO = new UsuariosDAO();
                altUsuDAO.alterarUsuario();
                System.out.println("Usuário alterado com sucesso!");
                UsuariosDAO remUsuDAO = new UsuariosDAO();
                remUsuDAO.removerUsuario();
                System.out.println("Usuário removido com sucesso!");
                UsuariosDAO pesqUsuDAO = new UsuariosDAO();
                pesqUsuDAO.autenticarUsuario();
                System.out.println("Usuário encontrado com sucesso!");


                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.inserirCliente();
                System.out.println("Cliente inserido com sucesso!");
                ClientesDAO altCliDAO = new ClientesDAO();
                altCliDAO.alterarCliente();
                System.out.println("Cliente alterado com sucesso!");
                ClientesDAO remCliDAO = new ClientesDAO();
                remCliDAO.removerCliente();
                System.out.println("Cliente removido com sucesso!");
                ClientesDAO pesqCliDAO = new ClientesDAO();
                pesqCliDAO.pesquisarCliente();
                System.out.println("Cliente encontrado com sucesso!");


                QuartosDAO quartosDAO = new QuartosDAO();
                quartosDAO.inserirQuarto();
                System.out.println("Quarto inserido com sucesso!");
                QuartosDAO altQuaDAO = new QuartosDAO();
                altQuaDAO.alterarQuarto();
                System.out.println("Quarto alterado com sucesso!");
                QuartosDAO remQuaDAO = new QuartosDAO();
                remQuaDAO.removerQuarto();
                System.out.println("Quarto removido com sucesso!");
                QuartosDAO pesqQuaDAO = new QuartosDAO();
                pesqQuaDAO.pesquisarQuarto();
                System.out.println("Quarto encontrado com sucesso!");


                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.inserirAdicionais();
                System.out.println("Adicionais inserido com sucesso!");

                RegrasDAO regrasDAO = new RegrasDAO();
                regrasDAO.inserirRegras();
                System.out.println("Cargo inserido com sucesso!");

                PedidosDAO pedidosDAO = new PedidosDAO();
                pedidosDAO.inserirPedidos();
                System.out.println("Pedido inserido com sucesso!");*/


               usuarioController.verificarCredenciais("admin@gmail.com", "123");


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