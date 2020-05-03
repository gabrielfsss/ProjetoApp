package com.gabriel.projeto1parte.model;

public class Cadastro {

    private Long id;
    private String nomeprod;
    private int quantestoq;
    private int precoprod;
    private String local;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public int getQuantestoq() {
        return quantestoq;
    }

    public void setQuantestoq(int quantestoq) {
        this.quantestoq = quantestoq;
    }

    public int getPrecoprod() {
        return precoprod;
    }

    public void setPrecoprod(int precoprod) {
        this.precoprod = precoprod;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
