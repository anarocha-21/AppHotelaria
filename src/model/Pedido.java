package model;
import java.util.Date;

public class Pedido {
    private int idPedido, idCliente, idUsuario;
    private String pagamento;
    private Date data;

    public Pedido(int idCliente, int idUsuario, String pagamento, Date data){
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.pagamento = pagamento;
        this.data = data;
    }

    public int getIdPedido() {
        return idPedido;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public String getPagamento() {
        return pagamento;
    }
    public Date getData() {
        return data;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    public void setData(Date data) {
        this.data = data;
    }
}



