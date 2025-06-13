package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirPedidos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedidos = conndb.prepareStatement("INSERT INTO pedidos" +
                    "(fk_usuarios, fk_clientes, pagamento) VALUES (?, ?, ?);");

            novoPedidos.setInt(1, 1);
            novoPedidos.setInt(2, 2);
            novoPedidos.setInt(3, 10);

            int linhaAfetada = novoPedidos.executeUpdate();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir pedidos: " + erro);
            return false;
        }
    }

    public boolean alterarPedidos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pedidoAlterado = conndb.prepareStatement("UPDATE pedidos SET fk_usuarios = ?, fk_clientes = ?, pagamento = ? WHERE id = ?; ");
            pedidoAlterado.setInt(1, 1);
            pedidoAlterado.setInt(2, 1);
            pedidoAlterado.setInt(3, 1);

            int linhaAfetada = pedidoAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar pedidos: " + erro);
            return false;
        }
    }

    public boolean removerPedidos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removePedidos = conndb.prepareStatement
                    ("DELETE FROM regras WHERE id = ?;");
            removePedidos.setInt(1, 1);
            int linhaAfetada = removePedidos.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao remover pedidos: " + erro);
            return false;
        }
    }

    public void pesquisarPedidos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarPedidos = conndb.prepareStatement("SELECT fk_usuarios, fk_clientes, pagamento FROM pedidos WHERE id = ?");
            buscarPedidos.setInt(1, 1);
            ResultSet resultado = buscarPedidos.executeQuery();

            while (resultado.next()) {
                int fk_usuarios = resultado.getInt("fk_usuarios");
                int fk_clientes = resultado.getInt("fk_clientes");
                int pagamento = resultado.getInt("pagamento");
                System.out.println("id usuario: " + fk_usuarios + " - id clientes: " + fk_clientes + " - pagamento: " + pagamento);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar pedido: " + erro);
        }
    }
}

