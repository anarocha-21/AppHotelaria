package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

        }catch (Exception erro) {
            System.out.println("Erro ao inserir cargo: " + erro);
            return false;
        }
    }
}







