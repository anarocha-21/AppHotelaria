package model;

public class Adicionais {
    private int idAdicional;
    private String nome;
    private double preco;

    public Adicionais(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public int getIdAdicional() {
        return idAdicional;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }

    public void setIdAdicional(int idAdicional) {
        this.idAdicional = idAdicional;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
