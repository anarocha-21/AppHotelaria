package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public boolean alterarReservas() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement reservasAlterado = conndb.prepareStatement("UPDATE reservas"
                    + "SET fk_pedidos = ?, fk_quartos = ?, fk_adicionais = ?, chegada = ?, saida = ? WHERE id = ?; ");
            reservasAlterado.setInt(1, 1);
            reservasAlterado.setInt(2, 1);
            reservasAlterado.setInt(3, 1);
            reservasAlterado.setInt(4, 1);
            //reservasAlterado.setDate(5, );
            //reservasAlterado.setDate(6, );

            int linhaAfetada = reservasAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar reserva: " + erro);
            return false;
        }
    }
    public void pesquisarReservas() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarReservas = conndb.prepareStatement("SELECT fk_pedidos, fk_quartos , fk_adicionais, chegada, saida FROM reservas WHERE id = ?");
            buscarReservas.setInt(1, 1);
            ResultSet resultado = buscarReservas.executeQuery();

            while (resultado.next()) {
                int fk_pedidos = resultado.getInt("pedidos");
                int fk_quartos = resultado.getInt("fk_quartos");
                int fk_adicionais = resultado.getInt("fk_adicionais");
                 //chegada = resultado.getInt("chegada");
                 //saida = resultado.getBoolean("quartos");
                System.out.println("id pedidos: " + fk_pedidos + " - id quartos: " + fk_quartos + " - id adicionais: " + fk_adicionais); //+ " - chegada: " + chegada + " - saida: " + saida);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar reserva: " + erro);
        }
    }
}