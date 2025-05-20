package model;

import java.util.Date;

public class Reserva {
    private int idReserva, idPedido, idQuarto, idAdicional;
    private Date inicio, fim;

    public Reserva(int idPedido, int idQuarto, int idAdicional, Date fim, Date inicio) {
        this.idPedido = idPedido;
        this.idQuarto = idQuarto;
        this.idAdicional = idAdicional;
        this.fim = fim;
        this.inicio = inicio;
    }


    public int getIdPedido() {
        return idPedido;
    }
    public int getIdQuarto() {
        return idQuarto;
    }
    public int getIdAdicional() {
        return idAdicional;
    }
    public Date getFim() {
        return fim;
    }
    public Date getInicio() {
        return inicio;
    }


    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }
    public void setIdAdicional(int idAdicional) {
        this.idAdicional = idAdicional;
    }
    public void setFim(Date fim) {
        this.fim = fim;
    }
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
}
