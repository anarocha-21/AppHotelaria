package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }

    public boolean alterarClientes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement clientesAlterado = conndb.prepareStatement("UPDATE clientes"
                    + "SET nome = ?, telefone = ?, cpf = ?, email = ?, WHERE id = ?; ");
            clientesAlterado.setString(1, "");
            clientesAlterado.setString(2, "");
            clientesAlterado.setString(3, "");
            clientesAlterado.setString(4, "");

            int linhaAfetada = clientesAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar quarto: " + erro);
            return false;
        }
    }

    public boolean removerClientes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeClientes = conndb.prepareStatement
                    ("DELETE FROM clientes WHERE id = ?;");
            removeClientes.setInt(1, 1);
            int linhaAfetada = removeClientes.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao remover clientes: " + erro);
            return false;
        }
    }

    public void pesquisarClientes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarClientes = conndb.prepareStatement("SELECT nome, telefone, cpf, email FROM clientes WHERE id = ?");
            buscarClientes.setInt(1, 1);
            ResultSet resultado = buscarClientes.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                String cpf = resultado.getString("cpf");
                String email = resultado.getString("email");
                System.out.println("nome: " + nome + " - tel: " + telefone + " - cpf: " + cpf + " - email: " + email);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar cliente: " + erro);
        }
    }
}

