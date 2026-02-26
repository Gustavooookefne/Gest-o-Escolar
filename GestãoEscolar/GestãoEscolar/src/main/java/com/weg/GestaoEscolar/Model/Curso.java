package com.weg.GestaoEscolar.Model;

public class Curso {
    private int id;
    private String nomeCurso;
    private int codigo;

    public Curso(int id, String nomeCurso, int codigo) {
        this.id = id;
        this.nomeCurso = nomeCurso;
        this.codigo = codigo;
    }

    public Curso(String nomeCurso, int codigo) {
        this.nomeCurso = nomeCurso;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
