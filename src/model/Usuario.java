package model;

public class Usuario extends Pessoa{

    private int idUsuario, role_id;
    private String senha;

    public Usuario(String nome, String email, String senha, int role_id) {
        super(nome, email);
        this.role_id = role_id;
        this.senha = senha;
    }

    public int getID() {
        return idUsuario;
    }
    public int getRole_id() {
        return role_id;
    }
    public String getSenha() {
        return senha;
    }

    public void setID(int id) {
        this.idUsuario = id;
    }
    public void setRole_id(String nome) {

    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
