package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegrasDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirRegras() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoRegras = conndb.prepareStatement("INSERT INTO regras" +
                    "(nome) VALUES (?);");

            //setar os parametros
            novoRegras.setString(1, "mateus bolsonaro");

            int linhaAfetada = novoRegras.executeUpdate();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir cargo: " + erro);
            return false;
        }
    }

    public boolean alterarRegras() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement regraAlterada = conndb.prepareStatement("UPDATE cargos SET nome = ? WHERE id = ?; ");
            regraAlterada.setString(1, "");

            int linhaAfetada = regraAlterada.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar cargo: " + erro);
            return false;
        }
    }

    public boolean removerRegras() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeRegras = conndb.prepareStatement
                    ("DELETE FROM regras WHERE id = ?;");
            removeRegras.setInt(1, 1);
            int linhaAfetada = removeRegras.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao remover regras: " + erro);
            return false;
        }
    }

    public void pesquisarCargos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarCargos = conndb.prepareStatement("SELECT nome FROM regras WHERE id = ?");
            buscarCargos.setInt(1, 1);
            ResultSet resultado = buscarCargos.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                System.out.println("nome: " + nome);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar cargo: " + erro);
        }
    }
}








