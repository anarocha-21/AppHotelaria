package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

                }catch (Exception erro) {
                System.out.println("Erro ao inserir adicionais: " + erro);
                return false;
            }
        }
    }
