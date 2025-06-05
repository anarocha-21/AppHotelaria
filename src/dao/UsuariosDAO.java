package dao;

import model.Usuario;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {
    //objeto para instanciar classe Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();
                PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios" +
                        "(nome, email, senha, fk_regras) VALUES (?, ?, md5(?), ?);");

                    //setar os parametros
                    novoUsuario.setString(1, "ana");
                    novoUsuario.setString(2, "analaurarocha@gmail.com");
                    novoUsuario.setString(3, "123");
                    novoUsuario.setInt(4,1);

                    int linhaAfetada = novoUsuario.executeUpdate();
                    return linhaAfetada > 0;
                }catch(Exception erro){
                System.out.println("Erro ao inserir usuario: " + erro);
                return false;
            }

        }
    }
