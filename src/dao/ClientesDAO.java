package dao;

import model.Usuario;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {
        try {
            Connection conndb = conexao.conectar();
                PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes " +
                    "(nome, telefone, cpf, email) VALUES (?, ?, ?, ?);");

                    //setar os parametros
                    novoCliente.setString(1, "mateus bolsonaro");
                    novoCliente.setString(2, "4556456");
                    novoCliente.setString(3, "78910");
                    novoCliente.setString(4, "bolso_.mateus@gmail.com");

                    int linhaAfetada = novoCliente.executeUpdate();
                    return linhaAfetada > 0;

                }catch (Exception erro) {
                System.out.println("Erro ao inserir cliente: " + erro);
                return false;
            }
        }

    }
