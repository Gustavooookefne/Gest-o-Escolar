package com.weg.GestaoEscolar.Model;

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private int matricula;
    private String dataNacimento;

    public Aluno(int id, String nome, String email, int matricula, String dataNacimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.dataNacimento = dataNacimento;
    }

    public Aluno(String nome, String email, int matricula, String dataNacimento) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.dataNacimento = dataNacimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(String dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

}
