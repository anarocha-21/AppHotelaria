package model;

public class Cliente extends Pessoa {
    private int idCliente;
    private String cpf, telefone;

    public Cliente(String nome, String cpf, String telefone, String email) {
        super(nome, email);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getIdCliente(){
        return idCliente;
    }
    public String getCpf(){
        return cpf;
    }
    public String getTelefone(){
        return telefone;
    }

    public void setIdCliente(int id){
        this.idCliente = id;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}