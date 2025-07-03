package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos " +
                    "(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES (?, ?, ?, ?, ?, ?);");

            //setar os parametros
            novoQuarto.setString(1, "mateus bolsonaro");
            novoQuarto.setInt(2, 1);
            novoQuarto.setInt(3, 1);
            novoQuarto.setInt(4, 1);
            novoQuarto.setInt(5, 1);
            novoQuarto.setBoolean(6, true);

            int linhaAfetada = novoQuarto.executeUpdate();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }

    public boolean alterarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement quartoAlterado = conndb.prepareStatement("UPDATE quartos"
                    + "SET nome = ?, numero = ?, qtd_cama_casal = ?, qtd_cama_solteiro = ?, preco = ?, disponivel = ? WHERE id = ?; ");
            quartoAlterado.setString(1, "");
            quartoAlterado.setInt(2, 1);
            quartoAlterado.setInt(3, 1);
            quartoAlterado.setInt(4, 1);
            quartoAlterado.setInt(5, 1);
            quartoAlterado.setBoolean(6, true);

            int linhaAfetada = quartoAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar quarto: " + erro);
            return false;
        }
    }

    public boolean removerQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeQuartos = conndb.prepareStatement
                    ("DELETE FROM quartos WHERE id = ?;");
            removeQuartos.setInt(1, 1);
            int linhaAfetada = removeQuartos.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao remover quartos: " + erro);
            return false;
        }
    }

    public void pesquisarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarQuartos = conndb.prepareStatement("SELECT nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel FROM quartos WHERE id = ?");
            buscarQuartos.setInt(1, 1);
            ResultSet resultado = buscarQuartos.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                int numero = resultado.getInt("numero");
                int qtd_cama_casal = resultado.getInt("qtd_cama_casal");
                int qtd_cama_solteiro = resultado.getInt("qtd_cama_solteiro");
                int preco = resultado.getInt("preco");
                boolean disponivel = resultado.getBoolean("disponivel");
                System.out.println("nome: " + nome + " - numero: " + numero + " - casal: " + qtd_cama_casal + " - solteiro: " + qtd_cama_solteiro + " - preço: " + preco + " - disponivel: " + disponivel);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar quarto: " + erro);
        }
    }
}
