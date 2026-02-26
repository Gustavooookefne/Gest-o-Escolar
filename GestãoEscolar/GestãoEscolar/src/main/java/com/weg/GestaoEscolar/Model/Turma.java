package com.weg.GestaoEscolar.Model;

public class Turma {
    private int id;
    private String nomeTurma;
    private Curso curso;
    private Professor professor;

    public Turma(int id, String nomeTurma, Curso curso, Professor professor) {
        this.id = id;
        this.nomeTurma = nomeTurma;
        this.curso = curso;
        this.professor = professor;
    }

    public Turma(String nomeTurma, Curso curso, Professor professor) {
        this.nomeTurma = nomeTurma;
        this.curso = curso;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
