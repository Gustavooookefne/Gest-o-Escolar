package com.weg.GestaoEscolar.Model;

public class Professor {
    private long id;
    private String nome;
    private String email;
    private String disiplina;

    public Professor(long id, String nome, String email, String disiplina) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.disiplina = disiplina;
    }

    public Professor(String nome, String email, String disiplina) {
        this.nome = nome;
        this.email = email;
        this.disiplina = disiplina;
    }

    public Professor() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisiplina() {
        return disiplina;
    }

    public void setDisiplina(String disiplina) {
        this.disiplina = disiplina;
    }
}
