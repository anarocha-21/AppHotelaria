package model;

public class Role {
    private int idRole;
    private String nome;

    public Role(String nome) {
        this.nome = nome;
    }

    public int getIdRole() {
        return idRole;
    }
    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
