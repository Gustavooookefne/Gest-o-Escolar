package com.weg.GestaoEscolar.Model;

public class Nota {
    private int id;
    private Aluno aluno;
    private Aula aula;
    private double nota;

    public Nota(int id, Aluno aluno, Aula aula, double nota) {
        this.id = id;
        this.aluno = aluno;
        this.aula = aula;
        this.nota = nota;
    }

    public Nota(Aluno aluno, Aula aula, double nota) {
        this.aluno = aluno;
        this.aula = aula;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
