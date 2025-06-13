package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicionais = conndb.prepareStatement("INSERT INTO adicionais" +
                    "(nome, preco) VALUES (?, ?);");

            //setar os parametros
            novoAdicionais.setString(1, "mateus bolsonaro");
            novoAdicionais.setInt(2, 200);

            int linhaAfetada = novoAdicionais.executeUpdate();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir adicionais: " + erro);
            return false;
        }
    }

    public boolean alterarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement adicionalAlterado = conndb.prepareStatement("UPDATE adicionais"
                    + "SET nome = ?, preco = ?, WHERE id = ?; ");
            adicionalAlterado.setString(1, "");
            adicionalAlterado.setString(2, "");

            int linhaAfetada = adicionalAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar adicional: " + erro);
            return false;
        }
    }

    public boolean removerAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeAdicionais = conndb.prepareStatement
                    ("DELETE FROM adicionais WHERE id = ?;");
            removeAdicionais.setInt(1, 1);
            int linhaAfetada = removeAdicionais.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao remover adicionais: " + erro);
            return false;
        }
    }

    public void pesquisarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarAdicionais = conndb.prepareStatement("SELECT nome, preco FROM adicionais WHERE id = ?");
            buscarAdicionais.setInt(1, 1);
            ResultSet resultado = buscarAdicionais.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                int preco = resultado.getInt("preco");
                System.out.println("nome: " + nome + " - preço: " + preco);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar adicionais: " + erro);
        }
    }
}
