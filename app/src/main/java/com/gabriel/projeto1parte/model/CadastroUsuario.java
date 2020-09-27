package com.gabriel.projeto1parte.model;

public class CadastroUsuario {

    private Integer id;
    private String nomeUsuario;
    private String senhaUsuario;

    public CadastroUsuario(Integer id, String usuarios, String senha) {
        this.id = id;
        this.nomeUsuario = usuarios;
        this.senhaUsuario = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}
