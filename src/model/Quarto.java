package model;

public class Quarto {
    private int idQuarto, qtdCamaCasal, qtdCamaSolt;
    private String nome, numero;
    private double preco;
    private boolean disponivel;

    public Quarto(String nome, String numero, int qtdCamaCasal, int qtdCamaSolt, double preco, boolean disponivel) {
        this.nome = nome;
        this.numero = numero;
        this.qtdCamaCasal = qtdCamaCasal;
        this.qtdCamaSolt = qtdCamaSolt;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public int getIdQuarto() {
        return idQuarto;
    }
    public String getNome() {
        return nome;
    }
    public String getNumero() {
        return numero;
    }
    public double getQtdCamaCasal() {
        return qtdCamaCasal;
    }
    public double getQtdCamaSolt() {
        return qtdCamaSolt;
    }
    public double getPreco() {
        return preco;
    }
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setQtdCamaCasal(int qtdCamaCasal) {
        this.qtdCamaCasal = qtdCamaCasal;
    }
    public void setQtdCamaSolt(int qtdCamaSolt) {
        this.qtdCamaSolt = qtdCamaSolt;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
