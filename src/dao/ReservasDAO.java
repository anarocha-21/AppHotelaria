package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {
    private Conexao conexao = new Conexao();
    public boolean removerReservas() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeReservas = conndb.prepareStatement
                    ("DELETE FROM regras WHERE id = ?;");
            removeReservas.setInt(1, 1);
            int linhaAfetada = removeReservas.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao remover reservas: " + erro);
            return false;
        }
    }
}